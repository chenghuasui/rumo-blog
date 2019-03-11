var vue = new Vue({
	el:"#app",
	//数据包
	data:{
		pageNo:1,
		pageSize:8,
		pages:0,
		pageNum:1,
		totalpage:0,
		blogs:[]
	},
	created:function(){
		//vue组件加载完毕以后执行的函数
		this.load();
	},
	//注册分页组件
	components:{
      'vue-nav': Vnav
    },
	computed:{
		//计算属性
		total:function(){
			return "100";
		}
	},
	//绑定事件的
	methods:{
		//点击每次分页的时候触发的回调函数,回调的过程中会把点击的页码返回出来，也就是cpageNo
		callback(cpageNo) {
		  this.$data.pageNo = cpageNo;
          this.load();
        },
		load:function(){
			var params = {pageNo:this.$data.pageNo,pageSize:this.$data.pageSize};
			this.$http.get("http://localhost:8087/blog/query",{params}).then((response)=>{
				var serverResponse = response.body;
				var pageInfo = serverResponse.data;
				//把后台查询出来的数据，返回给vue数据包，数据包的改变，会直接渲染MVVM。
				this.$data.blogs = pageInfo.list;
				this.$data.pageNum = pageInfo.pageNum;
				this.$data.pages = pageInfo.pages;
			});
			
			/*this.$http.get("http://localhost:8087/blog/query",{params}).then(function(response){
				var serverResponse = response.body;
				var pageInfo = serverResponse.data;
				//把后台查询出来的数据，返回给vue数据包，数据包的改变，会直接渲染MVVM。
				this.$data.blogs = pageInfo.list;
				this.$data.pageNum = pageInfo.pageNum;
				this.$data.pages = pageInfo.pages;
			},function(err){
				
			});*/
		}
	}
});


function formatDate(date, fmt) {
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    let o = {
        'M+': date.getMonth() + 1,
        'd+': date.getDate(),
        'h+': date.getHours(),
        'm+': date.getMinutes(),
        's+': date.getSeconds()
    };
    for (let k in o) {
        if (new RegExp(`(${k})`).test(fmt)) {
            let str = o[k] + '';
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
        }
    }
    return fmt;
};

function padLeftZero(str) {
    return ('00' + str).substr(str.length);
}

function parseData(datestr) {
	datestr = datestr.replace(/-/ig,"/");
	return new Date(datestr);
}

//日期格式化过滤器i
Vue.filter("formatDate",function(value,fmt){
	console.log(parseData(value));
	return formatDate(parseData(value),fmt);
});
