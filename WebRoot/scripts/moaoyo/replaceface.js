(function(e){if(typeof e.mk=="undefined"){e.mk={}}if(typeof e.mk.face=="undefined"){e.mk.face={}}var o=[{type:"hin-pop",name:"HIN-POP",data:["HIN-POP表情提示","鼓掌","yeah","ok","握手","有木有","五道杠","围观","伤不起","神马","浮云","喷血","睡觉","鄙视一下","v5","nb","偷笑","鬼脸熊猫","衰","猪头啊","懒得理你"],imgsuffix:".jpg",imgpath:"/images/hin-pop/"},{type:"dynamicFace",name:"动 态",data:["动态表情提示","花痴","爆哭","爆雷","飘过","怒","疑问","汗","无语","呲牙","爆眼","晕","吐","假笑","委屈","郁闷","砸扁","显摆","害羞","口水","惊讶"],imgsuffix:".gif",imgpath:"/images/dynamicFace/"},{type:"xiaerFace",name:"XIAER",data:["xiaer表情提示 xiaer版","惊了","猪得意","MIXI","太得意","三只眼","弱魔","暴吐","ji贼","中怒","真小气","邪恶","坏","小无语","惊怒","财迷","惨","长舌","不正经","闷","完了"],imgsuffix:".jpg",imgpath:"/images/xiaerFace/"},{type:"waver_h",name:"WAVER_H",data:["waver_h表情提示","暴怒","鄙视","烟酷","黑涩会","怪唇","变态","怀疑","啊","囧","小口水","骷髅","鼻血","猫脸","媒婆","可怜","挖鼻","我晕","熊猫","周扒皮","猪头"],imgsuffix:".jpg",imgpath:"/images/waver_h/"},{type:"rourou",name:"肉 肉",data:["人肉表情提示","小飘","怪得意","冷汗","飞吻","空","鼻涕","阿童木","各种拽","超人","不鸟","潜","歪嘴","烧香","扮鬼脸","香肠嘴","小恶魔","羞","飘泪","orz","打盹"],imgsuffix:".jpg",imgpath:"/images/rourou/"}],n=false,a="",k="smiles",l="",i=function(r,p){var q="";e.each(o,function(s,t){if(r==t.type){q="["+t.data[p]+"]"}});return q},h=function(r){var z=e("#"+r);var u=jQuery1.getElementPos(z[0]);var w=u.x+parseInt(z.width());var v=u.y+parseInt(z.height());var A={position:"absolute","z-index":"1000000",left:w+"px",top:v+"px",width:"400px","background-color":"#fff",padding:"12px",border:"1px solid #bfbfbf",display:"block"};var q={height:"20px","line-height":"20px","margin-bottom":"10px"};var s={border:"1px solid #fff",cursor:"pointer",color:"#F09","text-decoration":"underline","margin-right":"20px"};var t=e("<div />",{id:k,css:A});var p=e("<p />",{css:q});e.each(o,function(x,B){p.append(e("<span />",{css:s,text:B.name,mouseover:function(){e(this).css({border:"1px solid #f09"})},mouseout:function(){e(this).css({border:"1px solid #fff"})},click:function(){c(B.type)}}));var y=e("<div />",{id:B.type});if(x==0){y.css("display","block")}else{y.css("display","none")}e.each(B.data,function(C,D){if(C>0){$span=e("<span />",{css:{display:"inline-block",width:"78px",height:"50px","text-align":"center",border:"1px solid #fff",cursor:"pointer"},mouseover:function(){e(this).css({border:"1px solid #f09"})},mouseout:function(){e(this).css({border:"1px solid #fff"})}});$img=e("<img />",{src:mokosimg+B.imgpath+C+B.imgsuffix,alt:D,title:D,click:function(){f(B.type,C)}});$span.append($img);y.append($span)}});t.append(y)});t.prepend(p);t.appendTo(document.body)},c=function(p){n=false;e("#"+k+" > div").hide();e("#"+p).show()},g=function(p){if(n){var q=e("#"+k);if(q.size()>0){q.remove()}if(e("#"+a).size()!=0){e("#"+a).focus()}e(document).unbind("click.chooseFace")}n=true},f=function(r,p){var q=e("#"+a)[0];var t=q.value.length;var s=i(r,p);q.value=q.value.substring(0,l.start)+s+q.value.substring(l.end,t);j(q,l.start+s.length)},m=function(p){return p.replace(/[[^\]^]*/g,"")},d=function(v){var t,u,p,q;if(jQuery1.isIE){var r=document.selection;v.focus();p=r.createRange();q=p.duplicate();q.moveToElementText(v);q.setEndPoint("EndToEnd",p);t=q.text.length-p.text.length;u=t+p.text.length;v.blur()}else{t=v.selectionStart;u=v.selectionEnd}return{start:t,end:u}},j=function(r,p){p=p==null?r.value.length:p;r.focus();if(r.createTextRange){var q=r.createTextRange();q.move("character",p);q.select()}else{r.setSelectionRange(p,p)}};e.mk.face.popSmiles=function(q,p){e.mk.common.clearBlogSearchDiv();a=p;var r=e("#"+k);if(r.size()>0){r.remove();return false}l=d(e("#"+a)[0]);h(q);n=false;e(document).bind("click.chooseFace",g)};e.mk.face.replaceFace=function(x){if(x==null||x==""||(x.indexOf("<img ")==-1&&x.indexOf("<IMG ")==-1)||x.indexOf(">")==-1){return x}if(x.indexOf('src="')==-1){return x}var v=x.substring(x.indexOf('src="')+5);var p=v.substring(0,v.indexOf('"'));if(p.indexOf("images/")==-1){return x}var r=p.substring(p.indexOf("images/")+7,p.lastIndexOf("/"));var t=p.substring(p.lastIndexOf("/")+1,p.lastIndexOf("."));var s=x.toLowerCase();var q=s.indexOf("<img ");var u=s.substring(q).indexOf(">");var w=x.substring(q,q+u+1);if(w.indexOf("<")!=w.lastIndexOf("<")){w=w.substring(w.lastIndexOf("<"))}x=x.replace(w,i(r,t));return e.mk.face.replaceFace(x)};var b;_initFaceMap=function(){b={};e.each(o,function(p,q){e.each(q.data,function(s,r){b[r]=mokosimg+q.imgpath+s+q.imgsuffix})})};e.mk.face.formatImages=function(p){var q=e('[id^="'+p+'"]');if(q.size()==0){return}if(!b){_initFaceMap()}q.each(function(s,r){r=e(r);r.html(r.html().replace(/\[([\u4e00-\u9fa5\s\w]*)\]/g,function(t){var u=m(t);if(!b[u]){return t}return"<img src='"+b[u]+"' class='mokoface' title='"+u+"' alt='"+u+"' />"}))})};e.mk.face.formatImagesAlt=function(p){var q=e('[id^="'+p+'"]');if(q.size()==0){return}q.each(function(s,r){r=e(r);r.attr("title",m(r.attr("title")))})}})(jQuery1);