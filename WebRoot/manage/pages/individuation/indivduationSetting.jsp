<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
 	<meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312"/>
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />
	  
	
	  <link rel="stylesheet" type="text/css" href="../../../styles/ext-all.css" />
	  <link rel="stylesheet" type="text/css" href="../../../styles/table.css" />
      <link rel="stylesheet" type="text/css" href="../../../styles/cms.css" />
      <link rel="stylesheet" type="text/css" href="../../../styles/accordion.css" />
      <script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
      <script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
      <script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
      <script type="text/javascript" src="../../../scripts/ext-all.js"></script>
      <script type="text/javascript" src="../../../scripts/ext-accordion.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function(){
	      
	      var sms11 = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'sms11',
	              width:70,
	              forceSelection:true            	
	      });
		  
		  var sms1 = new Ext.form.TextField({
		  	width:150
		  });
		  sms1.applyTo('sms1');
		  
		  var sms2 = new Ext.form.TextField({
		  	width:150
		  });
		  sms2.applyTo('sms2');
		  
		  var sms3 = new Ext.form.TextField({
		  	width:107
		  });
		  sms3.applyTo('sms3');
		  
		  var sms4 = new Ext.form.TextField({
		  	width:107
		  });
		  sms4.applyTo('sms4');
		  
		  var sms5 = new Ext.form.TextField({
		  	width:107
		  });
		  sms5.applyTo('sms5');
		  
		  var sms6 = new Ext.form.TextField({
		  	width:107
		  });
		  sms6.applyTo('sms6');
		  
		   var sms7 = new Ext.form.TextField({
		  	width:107
		  });
		  sms7.applyTo('sms7');
		  
		   var sms8 = new Ext.form.TextField({
		  	width:107
		  });
		  sms8.applyTo('sms8');
		  
		   var sms9 = new Ext.form.TextField({
		  	width:107
		  });
		  sms9.applyTo('sms9');
		  
		   var sms10 = new Ext.form.TextField({
		  	width:107
		  });
		  sms10.applyTo('sms10');
		  
		   var sms11 = new Ext.form.TextField({
		  	width:107
		  });
		  sms11.applyTo('sms11');
		  
		   var sms12 = new Ext.form.TextField({
		  	width:107
		  });
		  sms12.applyTo('sms12');
		  
		   var sms13 = new Ext.form.TextField({
		  	width:107
		  });
		  sms13.applyTo('sms13');
		  
		   var sms14 = new Ext.form.TextField({
		  	width:107
		  });
		  sms14.applyTo('sms14');
		  
	    Ext.get('formPanel');
	   });
	   
	    $(document).ready(function(){
           $('#open').click(
	       function(){
	           $("#close").css("display","");
	           $('#customize').css("display","");
	           $("#open").css("display","none");
           });
           
           $('#close').click(
	       function(){	           
	           $("#open").css("display","");
	           $('#customize').css("display","none");
	           $("#close").css("display","none");
           });
       });
       
        $(document).ready(function(){
           $('#open1').click(
	       function(){
	           $("#close1").css("display","");
	           $('#customize1').css("display","");
	           $("#open1").css("display","none");
           });
           
           $('#close1').click(
	       function(){	           
	           $("#open1").css("display","");
	           $('#customize1').css("display","none");
	           $("#close1").css("display","none");
           });
       });
	   
	   function add()
	   {
	   		document.all.from1.action = "";
	   		document.all.from1.action = "saveActionRule.action?method=save";
	   		document.all.from1.submit();
	   }
	   
	   function city()
	   {
	   		var o = document.getElementsByTagName('INPUT');   
            for(var i=0;i<o.length;i++)   
            {   
              if(o[i].type == 'checkbox' && o[i].checked)  
              var param = o[i].value;
            }   
            alert(param);
            document.all.from1.action = "";
	   		document.all.from1.action = "queryCity.action?method=getAllCity&id="+param;
	   		document.all.from1.submit();
           <!-- window.open("pages/individuation/city.jsp","","width = 280,height = 200");-->
	   }
	   
	   function birthday()
	   {
	   		width  = 297;
			height = 165;
	   		windowX = (screen.width - width)/2;
			windowY = (screen.height - height)/2;
	
			features = 	"top=" + windowY + ",left=" + windowX;
			features = features + ",width=" + width + ",height=" + height;
	   		window.open("pages/individuation/birthday.jsp","",features);
	   }
	   
	    function product()
	    {
	   		width  = 400;
			height = 200;
	   		windowX = (screen.width - width)/2;
			windowY = (screen.height - height)/2;
			features = 	"top=" + windowY + ",left=" + windowX;
			features = features + ",width=" + width + ",height=" + height;
	    	window.open("pages/individuation/product.jsp","",features);
	    }
	   
	</script>
	<title>????????????????????????</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  name = "from1" action="" method="post" class="x-form">
				<input type = "hidden" name = "id">
				<div id="formPanel" style="width:680px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				 <fieldset>
				 	<legend>????????????????????????</legend>
				  <fieldset>
				  	<legend>????????????</legend>
				  		<div class = "x-form-item">
			  	 		<table width = "580">
			  	 			<tr>
			  	 				<td align="right">???????????????</td>
			  	 				<td><input id = "sms1" name = "adv_action_id" type = "text"></td>
			  	 				<td align="right">???????????????</td>
			  	 				<td><input id = "sms2" name = "adv_action_name" type = "text"></td>
			  	 			</tr>	
			  	 			<tr>
			  	 				<td align="right">?????????????????????</td>
			  	 				<td>
				  	 				<img id="open" src="images/icon_close.gif"/>
				  	 				<img id="close" style="display:none" src="images/icon_open.gif"/>
			  	 					<!--  <input type="button" id = "open"  value = "??????????????????" class="btn" >  -->
			  	 				</td>
			  	 				<td align="right">????????????????????????</td>
			  	 				<td>
			  	 					<img id="open1" src="images/icon_close.gif"/>
			  	 					<img id="close1" style="display:none" src="images/icon_open.gif"/>
			  	 					<!-- <input type="button"  value = "?????????????????????" class="btn" >  -->
			  	 				</td>
			  	 			</tr>
			  	 		</table>
			  	 		</div>
				  </fieldset>
				 <div style="display:none" id="customize" onclick="return false;" class="x-form-item">
				  <fieldset>
				  	<legend></legend>
				  		<table>
				  		    <tr style="nowrap:nowrap">
				  				<td>
				  				   <fieldset style="height:250;width:110">
						  			<legend>????????????</legend>
						  			<table border="1" width = "100"  bordercolor="#999999">
						  				<tr><td align="center" width="30"><a href = "#">??????</a></td><td align="center"><a href = "#">??????</a></td></tr>
						  				<tr><td align="center">01</td><td>????????????1</td></tr>
						  				<tr><td align="center">02</td><td>????????????1</td></tr>
						  				<tr><td align="center">03</td><td>????????????1</td></tr>
						  				<tr><td align="center">04</td><td>????????????1</td></tr>
						  				<tr><td align="center">05</td><td>????????????1</td></tr>
						  				<tr><td align="center">06</td><td>????????????1</td></tr>
						  				<tr><td align="center">07</td><td>????????????1</td></tr>
						  				<tr><td align="center">08</td><td>????????????1</td></tr>
						  				<tr><td align="center">09</td><td>????????????1</td></tr>
						  				<tr><td align="center">10</td><td>????????????1</td></tr>
						  			</table>
						  		  </fieldset>
				  				</td>
				  				<td>
				  				  <fieldset style="height:250;width:430">
				  			         <legend>??????????????????</legend>
				  			         	<table width="450" align="center" border="1" bordercolor="#999999">
				  			         		<tr>
				  			         			<td width="25%" align="right">???????????????</td>
				  			         			<td width="25%" ><input type = "text" name="loc_inst_id" id = "sms3" size="15"/></td>
				  			         			<td width="25%" align="right">???????????????</td>
				  			         			<td width="25%"><input type = "text" name="loc_inst_name" id = "sms4" size="15"/></td>
				  			         		</tr>
				  			         	</table>
				  			         	<table>
				  			         		<tr><td width="450" height="30">?????????????????????????????????</td></tr>
				  			         	</table>
				  			         	<table>
				  			         		<s:iterator id = "banks" value="%{#request.list}" status="st"> 
				  			         		  <tr>
				  			         			<td>
				  			         			   <table width="450" align="center"  bordercolor="#999999">	 
				  			         			     <tr>
				  			         				   <s:iterator id = "bankss" value="banks" status="st">
				  			         				   		<td><input type = "checkbox" name = "boxbank" value = "${bankss}" onclick="city();"/><s:property value= "bankss" /></td>
				  			         				   </s:iterator>
				  			         			     </tr>
				  			         			   </table>
				  			         			</td>
				  			         		   </tr>
				  			         		</s:iterator>
				  			         	</table>
				  		          </fieldset>
				  				</td>
				  			</tr>
				  		</table>
				  </fieldset>
				</div>  
				<div style="display:none" id="customize1" onclick="return false;" class="x-form-item">
				  <fieldset>
				  	<legend>?????????????????????</legend>
				  		<table>
				  			<tr style="nowrap:nowrap">
				  				<td>
				  					<fieldset style="height:250;width:110">
				  						<legend>????????????</legend>
				  						<table border="1" width = "100" bordercolor="#999999">
						  				<tr><td align="center" width="30"><a href = "#">??????</a></td><td align="center"><a href = "#">??????</a></td></tr>
						  				<tr><td align="center">01</td><td>????????????1</td></tr>
						  				<tr><td align="center">02</td><td>????????????1</td></tr>
						  				<tr><td align="center">03</td><td>????????????1</td></tr>
						  				<tr><td align="center">04</td><td>????????????1</td></tr>
						  				<tr><td align="center">05</td><td>????????????1</td></tr>
						  				<tr><td align="center">06</td><td>????????????1</td></tr>
						  				<tr><td align="center">07</td><td>????????????1</td></tr>
						  				<tr><td align="center">08</td><td>????????????1</td></tr>
						  				<tr><td align="center">09</td><td>????????????1</td></tr>
						  				<tr><td align="center">10</td><td>????????????1</td></tr>
						  				<tr><td align="center">11</td><td>????????????1</td></tr>
						  				<tr><td align="center">12</td><td>????????????1</td></tr>
						  				</table>
				  					</fieldset>
				  				</td>
				  				<td valign="top">
				  					 <fieldset style="height:255;width:430">
				  						<legend>????????????</legend>
				  						<table width="450" align="center" >
				  							<tr>
				  								<td>
				  									<table border="1"  bordercolor="#999999">
				  										<tr>
							  								<td width="25%" align="right">???????????????</td>
							  			         			<td width="25%" ><input type = "text" name="psn_inst_id" id = "sms5" size="15"/></td>
							  			         			<td width="25%" align="right">???????????????</td>
							  			         			<td width="25%"><input type = "text" name="psn_inst_name" id = "sms6" size="15"/></td>
							  							</tr>
				  									</table>
				  								</td>
				  							</tr>
				  							<tr>
				  								<td height="10">???????????????</td>
				  							</tr>
				  							<tr>
				  								<td>
				  									<table border="1"  bordercolor="#999999">
				  										<tr>
				  											<td><input type = "checkbox" name = ""></td>
				  											<td align="right">?????????</td>
				  											<td>
				  											<select name = "c_sex" id = "sms11">
				  												<option selected="selected" value="M">???</option>
				  												<option value="F">???</option>
				  											</select>
				  											</td>
				  											<td><br><br></td>
				  										</tr>
				  										<tr>
				  											<td><input type = "checkbox" name = ""></td>
				  											<td align="right">?????????</td>
				  											<td>??????<input type = "text" name = "c_year_max" id = "sms7" size="10"></td>
				  											<td>??????<input type = "text" name = "c_year_min" id = "sms8" size="10"></td>
				  										</tr>
				  										<tr>
				  											<td><input type = "checkbox" name = ""></td>
				  											<td align="right">?????????</td>
				  											<td colspan="2">
				  												<input type="button" name = "" value = "???????????????" align="middle" onclick="birthday();">
				  											</td>
				  											<td></td>
				  										</tr>
				  										<tr>
				  											<td><input type = "checkbox" name = "" ></td>
				  											<td>???????????????</td>
				  											<td>??????<input type = "text" name = "c_new_point_max" id = "sms9" size="10"></td>
				  											<td>??????<input type = "text" name = "c_new_point_min" id = "sms10" size="10"></td>
				  										</tr>
				  										<tr>
				  											<td><input type = "checkbox" name = ""></td>
				  											<td>???????????????</td>
				  											<td>??????<input type = "text" name = "c_credit_max" id = "sms11" size="10"></td>
				  											<td>??????<input type = "text" name = "c_credit_min" id = "sms12" size="10"></td>
				  										</tr>
				  										<tr>
				  											<td><input type = "checkbox" name = ""></td>
				  											<td>???????????????</td>
				  											<td>??????<input type = "text" name = "c_leftcredit_max" id = "sms13" size="10"></td>
				  											<td>??????<input type = "text" name = "c_leftcredit_min" id = "sms14" size="10"></td>
				  										</tr>
				  										<tr>
				  											<td><input type = "checkbox" name = ""></td>
				  											<td>???????????????</td>
				  											<td colspan="2">
				  												<input type="button" name = "" value = "?????????????????????" onclick="product();">
				  											</td>
				  											<td></td>
				  										</tr>
				  									</table>
				  								</td>
				  							</tr>
				  						</table>
				  					</fieldset>
				  				</td>
				  			</tr>
				  		</table>
				  </fieldset>
				 </div>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="button" value="??????"  class="btn" onclick="add();">
							</div> 
				  			<div class="x-form-btn">  
								<input type="reset" value="??????"  class="btn">
							</div>             
				  			<div style="clear:both"></div>
				  		</div>
				  </div>
				  </div>
				  </div>
				<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>
			 </div>
			</form>
		   </div>
		<!-- foot -->		
		<!-- <div id="footer" class="footer"></div> -->
	</div>
  </body>
</html>
