var clear="http://html.moko.hk/images/n.gif";pngfix=function(){var q=document.getElementsByTagName("*");var o=/\.png/i;var p=q.length;while(p-->0){var s=q[p];var j=s.style;if(s.src&&s.src.match(o)&&!j.filter){j.height=s.height;j.width=s.width;j.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+s.src+"',sizingMethod='crop')";s.src=clear}else{var t=s.currentStyle.backgroundImage;if(t.match(o)){var i=t.split('"');var m=(s.currentStyle.backgroundRepeat=="no-repeat")?"crop":"scale";j.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+i[1]+"',sizingMethod='"+m+"')";j.height=s.clientHeight+"px";j.backgroundImage="none";var n=s.getElementsByTagName("*");if(n){var r=n.length;if(s.currentStyle.position!="absolute"){j.position="static"}while(r-->0){if(!n[r].style.position){n[r].style.position="relative"}}}}}}};window.attachEvent("onload",pngfix);