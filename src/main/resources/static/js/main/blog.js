var mkBlog = {
	pageNo:1,
	pageSize:10,
	timer:null,
	init:function(){
		this.loadPage($("#posts").children().eq(0).data("psize"));
	},
	loadPage:function(totalPages){
		$("#page").Page({
		    totalPages: totalPages,//total Pages
		    liNums: 7,
		    activeClass: 'activP', //active class style
		    firstPage: '<',//first button name
		    lastPage: '>',//last button name
		    prv: '<<',//prev button name
		    next: '>>',//next button name
		    hasFirstPage: true,//whether has first button
		    hasLastPage: true,//whether has last button
		    hasPrv: true,//whether has prev button
		    hasNext: true,//whether has next button
		    callBack : function(page){//每次点击分页执行的回调函数
		    	//点击分页获取吓一条数据
		    	mkBlog.pageNo = page;
		    	mkBlog.loadBlog();
		    }
		});
	},
	
	//查询
	loadBlog:function(callback){
		if(mkBlog.timer)clearTimeout(mkBlog.timer);
		mkBlog.timer = setTimeout(function(){
			//获取参数
			var params = {"pageNo":mkBlog.pageNo,"pageSize":mkBlog.pageSize};
			$("#posts").load(basePath+"/blog/template",params,function(data){
				var psize = $("#posts").children().eq(0).data("psize");
				callback && callback(psize);
			});
		}, 200);
	},
	
	//保存
	save:function(){
		//校验
		if(!this.validator()){
			return;
		}
		
		//获取参数
		var title = $("#title").val();
		var categoryId = $("#categoryId").val();
		var description = $("#description").val();
		var userId = $("#userId").val();
		var status = $("#status").val();
		var isDelete = $("#isDelete").val();
		var img = $("#img").val();
		var tags = $("#tags").val();
		var isTop = $("#isTop").val();
		var isHot = $("#isHot").val();
		var content = $("#content").val();
		
		//设置参数
		var params = {
			"title":title,
			"categoryId":categoryId,
			"description":description,
			"userId":userId,
			"status":status,
			"isDelete":isDelete,
			"img":img,
			"tags":tags,
			"isTop":isTop,
			"isHot":isHot,
			"content":content
		};
		//保存方法
		var promise = $.post(basePath+"/blog/save",params);
		promise.done(function(response){
			console.log(response,response.data);
		}).fail(function(err){
			console.log(err);
		});
	},
	
	//修改
	update:function(){
		//校验
		if(!this.validator()){
			return;
		}
		
		//获取参数
		var id = $("#id").val();
		var title = $("#title").val();
		var categoryId = $("#categoryId").val();
		var description = $("#description").val();
		var userId = $("#userId").val();
		var status = $("#status").val();
		var isDelete = $("#isDelete").val();
		var img = $("#img").val();
		var tags = $("#tags").val();
		var isTop = $("#isTop").val();
		var isHot = $("#isHot").val();
		var content = $("#content").val();
		
		//设置参数
		var params = {
			"id":id,
			"title":title,
			"categoryId":categoryId,
			"description":description,
			"userId":userId,
			"status":status,
			"isDelete":isDelete,
			"img":img,
			"tags":tags,
			"isTop":isTop,
			"isHot":isHot,
			"content":content
		};
		//保存方法
		var promise = $.post(basePath+"/blog/update",params);
		promise.done(function(response){
			console.log(response,response.data);
		}).fail(function(err){
			console.log(err);
		});
	},
	
	//删除
	del:function(){
		//保存方法
		var id = 1;
		var promise = $.post(basePath+"/blog/delete/"+id);
		promise.done(function(response){
			console.log(response,response.data);
		}).fail(function(err){
			console.log(err);
		});
	},
	
	//校验器
	validator:function(){
		
		
		
		return true;
	}
};

$(function(){
	mkBlog.init();
});

