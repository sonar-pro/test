// vim: ts=2:sw=2:nu:fdc=4:nospell

// Create user extensions namespace (Ext.ux)
Ext.namespace('Ext.ux');

/**
  * Ext.ux.InfoPanel Extension Class
	*
	* @author  Ing. Jozef Sakalos
	* @version $Id: Ext.ux.InfoPanel.js 18 2007-06-13 17:55:16Z jozo $
  *
  * @class Ext.ux.InfoPanel
  * @extends Ext.ContentPanel
  * @constructor
  * Creates new Ext.ux.InfoPanel
  * @param {String/HTMLElement/Element} el The container element for this panel
  * @param {String/Object} config A string to set only the title or a config object
	* @param {String} content (optional) Set the HTML content for this panel
	* @cfg {Boolean} animate false to switch animation of expand/collapse off (defaults to true)
	* @cfg {String} bodyClass css class added to the body in addition to the default class(es)
  * @cfg {String/HTMLElement/Element} bodyEl This element is used as body of panel.
	* @cfg {Boolean} collapsed false to start with the expanded body (defaults to true)
	* @cfg {Boolean} collapseOnUnpin unpinned panel is collapsed when possible (defaults to true)
	* @cfg {Boolean} collapsible false to disable collapsibility (defaults to true)
	* @cfg {Boolean} draggable true to allow panel dragging (defaults to false)
	* @cfg {Float} duration Duration of animation in seconds (defaults to 0.35)
	* @cfg {String} easingCollapse Easing to use for collapse animation (e.g. 'backIn')
	* @cfg {String} easingExpand Easing to use for expand animation (e.g. 'backOut')
	* @cfg {String} icon Path for icon to display in the title
	* @cfg {Integer} minWidth minimal width in pixels of the resizable panel (no default)
	* @cfg {Integer} maxWidth maximal width in pixels of the resizable panel (no default)
	* @cfg {Integer} minHeight minimal height in pixels of the resizable panel (no default)
	* @cfg {Integer} maxHeight maximal height in pixels of the resizable panel (no default)
	* @cfg {String} panelClass Set to override the default 'x-dock-panel' class.
	* @cfg {Boolean} pinned true to start in pinned state (implies collapsed:false) (defaults to false)
	* @cfg {Boolean} resizable true to allow use resize width of the panel. 
	*  Handles are transparent. (defaults to false)
	* @cfg {String} shadowMode defaults to 'sides'.
	* @cfg {Boolean} showPin Show the pin button - makes sense only if panel is part of Accordion
	* @cfg {String} trigger 'title' or 'button'. Click where expands/collapses the panel (defaults to 'title')
	* @cfg {Boolean} useShadow Use shadows for undocked panels or panels w/o dock. (defaults to true)
  */
Ext.ux.InfoPanel = function(el, config, content) {

	// {{{
	// basic setup
	var oldHtml = content || null;
	if(config && config.content) {
		oldHtml = oldHtml || config.content;
		delete(config.content);
	}

	// save autoScroll to this.bodyScroll
	if(config && config.autoScroll) {
		this.bodyScroll = config.autoScroll;
		delete(config.autoScroll);
	}

	// call parent constructor
	Ext.ux.InfoPanel.superclass.constructor.call(this, el, config);

	this.desktop = Ext.get(this.desktop) || Ext.get(document.body);

	// shortcut of DomHelper
	var dh = Ext.DomHelper, oldTitleEl;

	this.el.clean();
	this.el.addClass(this.panelClass);

	// handle autoCreate
	if(this.autoCreate) {
		oldHtml = this.el.dom.innerHTML;
		this.el.update('');
		this.desktop.appendChild(this.el);
		this.el.removeClass('x-layout-inactive-content');
	}
	// handle markup
	else {
		this.el.clean();
		if(this.el.dom.firstChild && !this.bodyEl) {
			this.title = this.title || this.el.dom.firstChild.innerHTML;
			if(this.el.dom.firstChild.nextSibling) {
				this.body = Ext.get(this.el.dom.firstChild.nextSibling);
			}
			oldTitleEl = this.el.dom.firstChild;
			oldTitleEl = oldTitleEl.parentNode.removeChild(oldTitleEl);
			oldTitleEl = null;
		}
	}

	// get body element
	if(this.bodyEl) {
		this.body = Ext.get(this.bodyEl);
		this.el.appendChild(this.body);
	}
	// }}}
	// {{{
	// create title element
	var create = {
		tag:'div', unselectable:'on', cls:'x-unselectable x-layout-panel-hd x-dock-panel-title', children: [
			{tag:'table', cellspacing:0, children: [
				{tag:'tr', children: [
					{tag:'td', width:'100%', children: [
						{tag:'div', cls:'x-dock-panel x-layout-panel-hd-text x-dock-panel-title-text'}
					]}
					, {tag:'td', children:[
						{tag:'div', cls:'x-dock-panel x-dock-panel-tools'}
					]}
				]}
			]}
		]};
	this.titleEl = dh.insertFirst(this.el.dom, create, true);
	this.titleEl.addClassOnOver('x-dock-panel-title-over');
	this.titleEl.enableDisplayMode();
	this.titleTextEl = Ext.get(this.titleEl.select('.x-dock-panel-title-text').elements[0]);
	this.tools = Ext.get(this.titleEl.select('.x-dock-panel-tools').elements[0]);

	this.tm = Ext.util.TextMetrics.createInstance(this.titleTextEl);
	// }}}
	// {{{
	// set title
	if(this.title) {
		this.setTitle(this.title);
	}
	// }}}
	// {{{
	// create pin button
	if(this.showPin) {
		this.stickBtn = this.createTool(this.tools.dom, 'x-layout-stick');
		this.stickBtn.enableDisplayMode();
		this.stickBtn.on('click', function(e, target) {
			e.stopEvent();
			this.pinned = ! this.pinned;
			this.updateVisuals();
			this.fireEvent('pinned', this, this.pinned);
		}, this);
		this.stickBtn.hide();	
	}
	// }}}
	// {{{
	// create collapse button
	if(this.collapsible) {
		this.collapseBtn = this.createTool(this.tools.dom
			, (this.collapsed ? 'x-layout-collapse-east' : 'x-layout-collapse-south')
		);
		this.collapseBtn.enableDisplayMode();
		if('title' === this.trigger) {
			this.titleEl.addClass('x-window-header-text');
			this.titleEl.on({
				  click:{scope: this, fn:this.toggle}
				, selectstart:{scope: this, fn: function(e) {
						e.preventDefault();
						return false;
				}}
			}, this);
		}
		else {
			this.collapseBtn.on("click", this.toggle, this);
		}
	}
	// }}}
	// {{{
	// create body if it doesn't exist yet
	if(!this.body) {
			this.body = dh.append(this.el, {
				tag: 'div'
				, cls: this.bodyClass || null
				, html: oldHtml || ''
				}, true);
	}
	this.body.enableDisplayMode();
	if(this.collapsed && !this.pinned) {
		this.body.hide();
	}
	else if(this.pinned) {
		this.body.show();
		this.collapsed = false;
		this.updateVisuals();
	}
	this.body.addClass(this.bodyClass);
	this.body.addClass('x-dock-panel-body-undocked');

	// bodyScroll
	// autoScroll -> bodyScroll is experimental due to IE bugs
	if(!Ext.isIE) {
		this.body.setStyle('overflow', this.bodyScroll === true ? 'auto' : 'hidden');
	}
	// }}}
	// {{{
	// add events
	this.addEvents({
		/**
			* @event beforecollapse
			* Fires before collapse is taking place. Return false to cancel collapse
			* @param {Ext.ux.InfoPanel} this
			*/
		beforecollapse: true
		/**
			* @event collapse
			* Fires after collapse
			* @param {Ext.ux.InfoPanel} this
			*/
		, collapse: true
		/**
			* @event beforecollapse
			* Fires before expand is taking place. Return false to cancel expand
			* @param {Ext.ux.InfoPanel} this
			*/
		, beforeexpand: true
		/**
			* @event expand
			* Fires after expand
			* @param {Ext.ux.InfoPanel} this
			*/
		, expand: true
		/**
			* @event pinned
			* Fires when panel is pinned/unpinned
			* @param {Ext.ux.InfoPanel} this
			* @param {Boolean} pinned true if the panel is pinned
			*/
		, pinned: true
		/**
			* @event animationcompleted
			* Fires when animation is completed
			* @param {Ext.ux.InfoPanel} this
			*/
		, animationcompleted: true
		/**
			* @event boxchange
			* Fires when the panel is resized
			* @param {Ext.ux.InfoPanel} this
			* @param {Object} box
			*/
		, boxchange: true

		/**
			* @event redize
			* Fires when info panel is resized
			* @param {Ext.ux.InfoPanel} this
			* @param {Integer} width New width
			* @param {Integer} height New height
			*/
		, resize: true

		/**
			* @event destroy
			* Fires after the panel is destroyed
			* @param {Ext.ux.InfoPanel} this
			*/
		, destroy: true

	});
	// }}}
	// {{{
	// setup dragging, resizing, and shadow
	this.setDraggable(this.draggable);
	this.setResizable(!this.collapsed);
	this.setShadow(this.useShadow);

	/*
	// todo revise
	if(this.minHeight && !this.docked) {
		this.setHeight(this.minHeight);
	}

	if(this.minWidth && !this.docked) {
		this.setWidth(this.minWidth);
	}
	*/
	// }}}

	this.id = this.el.id;

}; // end of constructor

// extend
Ext.extend(Ext.ux.InfoPanel, Ext.ContentPanel, {

	// {{{
	// defaults
	collapsible: true
	, collapsed: true
	, collapseOnUnpin: true
	, pinned: false
	, trigger: 'title'
	, animate: true
	, duration: 0.35
	, draggable: false
	, resizable: false
	, docked: false
	, useShadow: false
	, bodyClass: 'x-dock-panel-body'
	, panelClass: 'x-dock-panel'
	, shadowMode: 'sides'
	, dragPadding: {
		  left:8
		, right:16
		, top:0
		, bottom:8
	}
	, lastWidth: 0
	, lastHeight: 0
	, autoScroll: false
	// }}}
	// {{{
	/**
		* Called internally to create collapse button
		* Calls utility method of Ext.LayoutRegion createTool
		* @param {Element/HTMLElement/String} parentEl element to create the tool in
		* @param {String} className class of the tool
		*/
	, createTool : function(parentEl, className){
		return Ext.LayoutRegion.prototype.createTool(parentEl, className);
  }
	// }}}
	// {{{
	/**
		* Set title of the InfoPanel
		* @param {String} title Title to set
		* @return {Ext.ux.InfoPanel} this
		*/
	, setTitle: function(title) {
		this.title = title;
		this.titleTextEl.update(title);
		if(this.icon) {
			this.titleTextEl.set({
				style: 
					'background-image:url(' 
					+ this.icon 
					+ ');background-repeat:no-repeat;background-position:3px 50%;padding-left:23px;'
			});
		}
		return this;
	}
	// }}}
	// {{{
	/**
		* Get current title
		* @return {String} Current title
		*/
	, getTitle: function() {
		return this.title;
	}
	// }}}
	// {{{
	/**
		* Returns body element
		* This overrides the ContentPanel getEl for convenient access to the body element
		* @return {Element} this.body
		*/
	, getEl: function() {
		return this.body;
	}
	// }}}
	// {{{
	/**
		* Update the innerHTML of this element, optionally searching for and processing scripts
    * @param {String} html The new HTML
    * @param {Boolean} loadScripts (optional) true to look for and process scripts
    * @param {Function} callback For async script loading you can be noticed when the update completes
    * @return {Ext.Element} this
		*/
	, update: function(html, loadScripts, callback) {
		this.body.update(html, loadScripts, callback);
		return this;
	}
	// }}}
	// {{{
	/**
		* Expands the panel
		* @return {Ext.ux.InfoPanel} this
		*/
	, expand: function() {

		// do nothing if already expanded
		if(!this.collapsed) {
			return this;
		}

		// fire beforeexpand event
		if(false === this.fireEvent('beforeexpand', this)) {
			return this;
		}

		// reset collapsed flag
		this.collapsed = false;

		// hide shadow
		if(!this.docked) {
			this.setShadow(false);
		}

		// enable resizing
		if(this.resizer && !this.docked) {
			this.setResizable(true);
		}
        
        this.body.setStyle('height','');
		
		// animate expand
		if(this.animate) {
				this.body.slideIn('t', {
					easing: this.easingExpand || null
					, scope: this
					, duration: this.duration
					, callback: this.updateVisuals
				});
		}

		// don't animate, just show
		else {
			this.body.show();
			this.updateVisuals();
			this.fireEvent('animationcompleted', this);
		}
                
		// fire expand event
		this.fireEvent('expand', this);

		return this;

	}
	// }}}
	// {{{
	/**
		* Toggles the expanded/collapsed states
		* @return {Ext.ux.InfoPanel} this
		*/
	, toggle: function() {
			if(this.collapsed) {
				this.expand();
			}
			else {
				this.collapse();
			}
			return this;
	}
	// }}}
	// {{{
	/**
		* Collapses the panel
		* @return {Ext.ux.InfoPanel} this
		*/
	, collapse: function() {

		// do nothing if already collapsed or pinned
		if(this.collapsed || this.pinned) {
			return this;
		}

		// fire beforecollapse event
		if(false === this.fireEvent('beforecollapse', this)) {
				return this;
		}

		if(this.bodyScroll /*&& !Ext.isIE*/) {
			this.body.setStyle('overflow','hidden');
		}

		// set collapsed flag
		this.collapsed = true;

		// hide shadow
		this.setShadow(false);

		// disable resizing of collapsed panel
		if(this.resizer) {
			this.setResizable(false);
		}

		// animate collapse
		if(this.animate) {
				this.body.slideOut('t', {
					easing: this.easingCollapse || null
					, scope: this
					, duration: this.duration
					, callback: this.updateVisuals
				});
		}

		// don't animate, just hide
		else {
			this.body.hide();
			this.updateVisuals();
			this.fireEvent('animationcompleted', this);
		}

		// fire collapse event
		this.fireEvent('collapse', this);

		return this;

	}
	// }}}
	// {{{
	/**
		* Called internally to update class of the collapse button 
		* as part of expand and collapse methods
		*
		* @return {Ext.ux.InfoPanel} this
		*/
	, updateVisuals: function() {

			// handle collapsed state
			if(this.collapsed) {
				if(this.showPin) {
					this.collapseBtn.show();
					this.stickBtn.hide();
				}
				Ext.fly(this.collapseBtn.dom.firstChild).replaceClass(
					'x-layout-collapse-south', 'x-layout-collapse-east'
				);
				this.body.replaceClass('x-dock-panel-body-expanded', 'x-dock-panel-body-collapsed');
				this.titleEl.replaceClass('x-dock-panel-title-expanded', 'x-dock-panel-title-collapsed');
			}
			
			// handle expanded state
			else {
				if(this.showPin) {
					if(this.pinned) {	
						Ext.fly(this.stickBtn.dom.firstChild).replaceClass('x-layout-stick', 'x-layout-stuck');
						this.titleEl.addClass('x-dock-panel-title-pinned');
					}
					else {
						Ext.fly(this.stickBtn.dom.firstChild).replaceClass('x-layout-stuck', 'x-layout-stick');
						this.titleEl.removeClass('x-dock-panel-title-pinned');
					}
					this.collapseBtn.hide();
					this.stickBtn.show();
				}
				else {
					Ext.fly(this.collapseBtn.dom.firstChild).replaceClass(
						'x-layout-collapse-east', 'x-layout-collapse-south'
					);
				}
				this.body.replaceClass('x-dock-panel-body-collapsed', 'x-dock-panel-body-expanded');
				this.titleEl.replaceClass('x-dock-panel-title-collapsed', 'x-dock-panel-title-expanded');
			}

			// show shadow if necessary
			if(!this.docked) {
				this.setShadow(true);
			}

			if(this.bodyScroll && !this.docked && !this.collapsed /*&& !Ext.isIE*/) {
				this.body.setStyle('overflow', 'auto');
			}

			this.constrainToDesktop();

			// fire animationcompleted event
			this.fireEvent('animationcompleted', this);

			// clear visibility style of body's children
			var kids = this.body.select('div[className!=x-grid-viewport],input{visibility}');
//			var kids = this.body.select('div,input{visibility}');
			kids.setStyle.defer(1, kids, ['visibility','']);

			// restore visibility of grid-viewport if any
//			var gvp = this.body.select('div.x-grid-viewport');
//			gvp.setStyle('visibility', this.collapsed ? 'hidden' : 'visible');

			return this;
	}
	// }}}
	// {{{
	/**
		* Creates toolbar
		* @param {Array} config Configuration for Ext.Toolbar
		* @param {Boolean} bottom true to create bottom toolbar. (defaults to false = top toolbar)
		* @return {Ext.Toolbar} Ext.Toolbar object
		*/
	, createToolbar: function(config, bottom) {
			var create = {tag:'div'}, tbEl;
			config = config || null;
			if(bottom) {
				tbEl = Ext.DomHelper.append(this.body, create, true);
				tbEl.addClass('x-dock-panel-toolbar-bottom');
			}
			else {
				tbEl = Ext.DomHelper.insertFirst(this.body, create, true);
				tbEl.addClass('x-dock-panel-toolbar');
			}
			this.toolbar = new Ext.Toolbar(tbEl, config);
			return this.toolbar;
	}
	// }}}
	// {{{
	/**
		* Set the panel draggable
		* Uses lazy creation of dd object
		* @param {Boolean} enable pass false to disable dragging
		* @return {Ext.ux.InfoPanel} this
		*/
	, setDraggable: function(enable) {

		if(!this.draggable) {
			return this;
		}

		// lazy create proxy
		var dragTitleEl;
		if(!this.proxy) {
			this.proxy = this.el.createProxy('x-dlg-proxy');

			// setup title
			dragTitleEl = Ext.DomHelper.append(this.proxy, {tag:'div'}, true);
			dragTitleEl.update(this.el.dom.firstChild.innerHTML);
			dragTitleEl.dom.className = this.el.dom.firstChild.className;
			if(this.collapsed && Ext.isIE) {
				dragTitleEl.dom.style.borderBottom = "0";
			}

			this.proxy.hide();
			this.proxy.setOpacity(0.5);
			this.dd = new Ext.dd.DDProxy(this.el.dom, 'PanelDrag', {
				dragElId: this.proxy.id
				, scroll: false
			});
			this.dd.scroll = false;
			this.dd.afterDrag = function() {
				if(this.panel && this.panel.shadow && !this.panel.docked) {
					this.panel.shadow.show(this.panel.el);
				}
			};

			this.constrainToDesktop();
			Ext.EventManager.onWindowResize(this.moveToViewport, this);
		}

		this.dd.panel = this;
		this.dd.setHandleElId(this.titleEl.id);
		if(false === enable) {
			this.dd.lock();
		}
		else {
			this.dd.unlock();
		}

		return this;
	}
	// }}}
	// {{{
	/**
		* Set the panel resizable
		* Uses lazy creation of the resizer object
		* @param {Boolean} pass false to disable resizing
		* @return {Ext.ux.InfoPanel} this
		*/
	, setResizable: function(enable) {

		if(!this.resizable) {
			return this;
		}

		// {{{
		// lazy create resizer
		if(!this.resizer) {

			// {{{
			// create resizer
			this.resizer = new Ext.Resizable(this.el, {
				handles: 's w e sw se'
				, minWidth: this.minWidth || this.tm.getWidth(this.getTitle()) + 56 || 48
				, maxWidth: this.maxWidth || 9999
				, minHeight: this.minHeight || 48
				, maxHeight: this.maxHeight || 9999
				, transparent: true
				, draggable: false
			});
			// }}}
			// {{{
			// install event handlers
			this.resizer.on({
				beforeresize: {
					scope:this
					, fn: function(resizer, e) {
						var viewport = this.getViewport();
						var box = this.getBox();

						var pos = resizer.activeHandle.position;

						// left constraint
						if(pos.match(/west/)) {
							resizer.minX = viewport.x + (this.dragPadding.left || 8);
						}

						// down constraint
						if(pos.match(/south/)) {
							resizer.oldMaxHeight = resizer.maxHeight;
							resizer.maxHeight = viewport.y + viewport.height - box.y - (this.dragPadding.bottom || 8);
						}

						// right constraint
						if(pos.match(/east/)) {
							resizer.oldMaxWidth = resizer.maxWidth;
							resizer.maxWidth = viewport.x + viewport.width - box.x - (this.dragPadding.right || 10);
						}
				}}
				, resize: {
					scope: this
					, fn: function(resizer, width, height, e) {
						resizer.maxHeight = resizer.oldMaxHeight || resizer.maxHeight;
						resizer.maxWidth = resizer.oldMaxWidth || resizer.maxWidth;
						this.setSize(width, height);
						this.constrainToDesktop();
						this.fireEvent('boxchange', this, this.el.getBox());
						this.fireEvent('resize', this, width, height);
				}}
			});
			// }}}

		}
		// }}}

		this.resizer.enabled = enable;

		// this is custom override of Ext.Resizer
		this.resizer.showHandles(enable);

		return this;
	}
	// }}}
	// {{{
	/**
		* Called internally to clip passed width and height to viewport
		* @param {Integer} w width
		* @param {Integer} h height
		* @return {Object} {width:safeWidth, height:safeHeight}
		*/
	, safeSize: function(w, h) {
		var viewport = this.getViewport();
		var box = this.getBox();
		var gap = 0;
		var safeSize = {width:w, height:h};

		safeSize.height = 
			box.y + h + this.dragPadding.bottom + gap > viewport.height + viewport.y 
			? viewport.height - box.y + viewport.y - this.dragPadding.bottom - gap 
			: safeSize.height
		;

		safeSize.width = 
			box.x + w + this.dragPadding.right + gap > viewport.width + viewport.x
			? viewport.width - box.x + viewport.x - this.dragPadding.right - gap 
			: safeSize.width
		;

		return safeSize;
	}
	// }}}
	// {{{
	/**
		* Called internally to get current viewport
		* @param {Element/HTMLElement/String} desktop Element to get size and position of
		* @return {Object} viewport {x:x, y:y, width:width, height:height} x and y are page coords
		*/
	, getViewport: function(desktop) {

		desktop = desktop || this.desktop || document.body;
		var viewport = Ext.get(desktop).getViewSize();
		var xy;
		if(document.body === desktop.dom) {
			viewport.x = 0;
			viewport.y = 0;
		}
		else {
			xy = desktop.getXY();
			viewport.x = isNaN(xy[0]) ? 0 : xy[0];
			viewport.y = isNaN(xy[1]) ? 0 : xy[1];
		}

		return viewport;
	}
	// }}}
	// {{{
	/**
		* Sets the size of the panel. Demanded size is clipped to the viewport
		*
		* @param {Integer} w width to set
		* @param {Integer} h height to set
		* @return {Ext.ux.InfoPanel} this
		*/
	, setSize: function(w, h) {
		var safeSize = this.safeSize(w, h);
		this.setWidth(safeSize.width);
		this.setHeight(safeSize.height);

		if(!this.docked) {
			this.setShadow(true);
		}
	}
	// }}}
	// {{{
	/**
		* Sets the width of the panel. Demanded width is clipped to the viewport
		*
		* @param {Integer} w width to set
		* @return {Ext.ux.InfoPanel} this
		*/
	, setWidth: function(w) {
		this.el.setWidth(w);
		this.body.setStyle('width','');
		if(!this.docked) {
			this.setShadow(true);
		}
		this.lastWidth = w;

		return this;
	}
	// }}}
	// {{{
	/**
		* Sets the height of the panel. Demanded height is clipped to the viewport
		*
		* @param {Integer} h height to set
		* @return {Ext.ux.InfoPanel} this
		*/
	, setHeight: function(h) {
		var newH = h - this.titleEl.getHeight();
		if(0 < newH) {
			this.body.setHeight(newH);
		}
		else {
			this.body.setStyle('height','');
		}

		if(!this.docked) {
			this.setShadow(true);
		}
//		this.lastHeight = h;
		this.el.setStyle('height','');

		return this;
	}
	// }}}
	// {{{
	/**
		* Called internally to set x, y, width and height of the panel
		*
		* @param {Object} box
		* @return {Ext.ux.InfoPanel} this
		*/
	, setBox: function(box) {
		this.el.setBox(box);
		this.moveToViewport();
		this.setSize(box.width, box.height);

		return this;
	}
	// }}}
	// {{{
	/**
		* Called internally to get the box of the panel
		*
		* @return {Object} box
		*/
	, getBox: function() {
		return this.el.getBox();
	}
	// }}}
	// {{{
	/**
		* Turns shadow on/off
		* Uses lazy creation of the shadow object
		* @param {Boolean} shadow pass false to hide, true to show the shadow
		* @return {Ext.ux.InfoPanel} this
		*/
	, setShadow: function(shadow) {

		// if I have shadow but shouldn't use it
		if(this.shadow && !this.useShadow) {
			this.shadow.hide();
			return this;
		}

		// if I shouldn't use shadow
		if(!this.useShadow) {
			return this;
		}

		// if I don't have shadow
		if(!this.shadow) {
			this.shadow = new Ext.Shadow({mode:this.shadowMode});
		}

		// show or hide
		var zindex;
		if(shadow) {
			this.shadow.show(this.el);

			// fix the Ext shadow z-index bug
			zindex = parseInt(this.el.getStyle('z-index'), 10);
			zindex = isNaN(zindex) ? '' : zindex - 1;
			this.shadow.el.setStyle('z-index', zindex);
		}
		else {
			this.shadow.hide();
		}

		return this;

	}
	// }}}
	// {{{
	/**
		* Show the panel
		* @param {Boolean} show (optional) if false hides the panel instead of show
		* @param {Boolean} alsoUndocked show/hide also undocked panel (defaults to false)
		* @return {Ext.ux.InfoPanel} this
		*/
	, show: function(show, alsoUndocked) {

		// ignore undocked panels if not forced to
		if(!this.docked && true !== alsoUndocked) {
			return this;
		}

		show = (false === show ? false : true);
		if(!this.docked) {
			this.setShadow(show);
		}

		this.el.setStyle('display', show ? '' : 'none');
		return this;
	}
	// }}}
	// {{{
	/**
		* Hide the panel
		* @param {Boolean} alsoUndocked show/hide also undocked panel (defaults to false)
		* @return {Ext.ux.InfoPanel} this
		*/
	, hide: function(alsoUndocked) {
		this.show(false, alsoUndocked);
	}
	// }}}
	// {{{
	/**
		* Constrains dragging of this panel to desktop boundaries
		* @param {Element} desktop the panel is to be constrained to
		* @return {Ext.ux.InfoPanel} this
		*/
	, constrainToDesktop: function(desktop) {
		desktop = desktop || this.desktop;
		if(desktop && this.dd) {
			this.dd.constrainTo(desktop, this.dragPadding, false);
		}
		return this;
	}
	// }}}
	// {{{
	/**
		* Called internally to move the panel to the viewport. 
		* Also constrains the dragging to the desktop
		*
		* @param {Object} viewport (optional) object {x:x, y:y, width:width, height:height}
		* @return {Ext.ux.InfoPanel} this
		*/
	, moveToViewport: function(viewport) {
		viewport = viewport && !isNaN(viewport.x) ? viewport : this.getViewport();
		var box = this.getBox();
		var moved = false;
		var gap = 10;

		// horizontal
		if(box.x + box.width + this.dragPadding.right > viewport.x + viewport.width) {
			moved = true;
			box.x = viewport.width + viewport.x - box.width - this.dragPadding.right - gap;
		}
		if(box.x - this.dragPadding.left < viewport.x) {
			moved = true;
			box.x = viewport.x + this.dragPadding.left + gap;
		}

		// vertical
		if(box.y + box.height + this.dragPadding.bottom > viewport.y + viewport.height) {
			moved = true;
			box.y = viewport.height + viewport.y - box.height - this.dragPadding.bottom - gap;
		}
		if(box.y - this.dragPadding.top < viewport.y) {
			moved = true;
			box.y = viewport.y + this.dragPadding.top + gap;
		}

		var oldOverflow;
		if(moved) {
			// sanity clip
			box.x = box.x < viewport.x ? viewport.x : box.x;
			box.y = box.y < viewport.y ? viewport.y : box.y;

			// prevent scrollbars from appearing
			this.desktop.oldOverflow = this.desktop.oldOverflow || this.desktop.getStyle('overflow');
			this.desktop.setStyle('overflow', 'hidden');

			// set position
			this.el.setXY([box.x, box.y]);

			// restore overflow
			this.desktop.setStyle.defer(100, this.desktop, ['overflow', this.desktop.oldOverflow]);

			if(!this.docked) {
				this.setShadow(true);
			}
		}

		this.constrainToDesktop();

		return this;
	}
// }}}

	/**
		* destroys the panel
		*/
	, destroy: function() {
		if(this.shadow) {
			this.shadow.hide();
		}
		if(this.collapsible) {
			this.collapseBtn.removeAllListeners();
			this.titleEl.removeAllListeners();
		}

		if(this.resizer) {
			this.resizer.destroy();
		}
		if(this.dd) {
			if(this.proxy) {
				this.proxy.removeAllListeners();
				this.proxy.remove();
			}
			this.dd.unreg();
			this.dd = null;
		}

		this.body.removeAllListeners();

		// call parent destroy
		Ext.ux.InfoPanel.superclass.destroy.call(this);

		this.fireEvent('destroy', this);

	}

}); // end of extend

// {{{
// show/hide resizer handles override
Ext.override(Ext.Resizable, {
	
	/**
		* Hide resizer handles
		*/
	hideHandles: function() {
		this.showHandles(false);
	} // end of function hideHandles

	/**
		* Show resizer handles
		*
		* @param {Boolean} show (true = show, false = hide)
		*/
	, showHandles: function(show) {
		show = (false === show ? false : true);
		var pos;
		for(var p in Ext.Resizable.positions) {
			pos = Ext.Resizable.positions[p];
			if(this[pos]) {
				this[pos].el.setStyle('display', show ? '' : 'none');
			}
		}
	} // end of function showHandles
// }}}

});


/**
  * Ext.ux.Accordion Extension Class
	*
	* @author  Ing. Jozef Sakalos
	* @version $Id: Ext.ux.Accordion.js 18 2007-06-13 17:55:16Z jozo $
  *
  * @class Ext.ux.Accordion
  * @extends Ext.ContentPanel
  * @constructor
  * @param {String/HTMLElement/Element} el The container element for this panel
  * @param {String/Object} config A string to set only the title or a config object
	* @cfg {Boolean} animate global animation flag for all panels. (defaults to true)
	* @cfg {Boolean} boxWrap set to true to wrap wrapEl the body is child of (defaults to false)
	* @cfg {Boolean} draggable set to false to disallow panels dragging (defaults to true)
	* @cfg {Boolean} fitHeight set to true if you use fixed height dock
	* @cfg {Boolean} independent true to make panels independent (defaults to false)
	* @cfg {Integer} initialHeight Initial height to set box to (defaults to 0)
	* @cfg {Boolean} monitorWindowResize if true panels are moved to 
	*  viewport if window is small (defaults to true)
	* @cfg {Boolean} resizable global resizable flag for all panels (defaults to true)
	* @cfg {Boolean} undockable true to allow undocking of panels (defaults to true)
	* @cfg {Boolean} useShadow global useShadow flag for all panels. (defaults to true)
	* @cfg {Element/HTMLElement/String} wrapEl Element to wrap with nice surrounding
  */
Ext.ux.Accordion = function(el, config) {
	
	// call parent constructor
	Ext.ux.Accordion.superclass.constructor.call(this, el, config);

	// create collection for panels
	this.items = new Ext.util.MixedCollection();

	// assume no panel is expanded
	this.expanded = null;

	// {{{
	// install event handlers
	this.on({

		// {{{
		// runs before expansion. Triggered by panel's beforeexpand event
		beforeexpand: {
			  scope: this
			, fn: function(panel) {
					// raise panel above others
					if(!panel.docked) {
						this.raise(panel);
					}

					// set fixed height
					var panelBodyHeight;
					if(this.fitHeight && panel.docked) {
						panelBodyHeight = this.getPanelBodyHeight();
						if(panelBodyHeight) {
							panel.body.setHeight(panelBodyHeight);
						}
					}

					if(panel.docked) {
						this.expandCount++;
						this.expanding = true;
//						this.setDockScroll(false);
					}

					// don't collapse others if independent or not docked
					if(this.independent || !panel.docked) {
						return this;
					}

					// collapse expanded panel
					if(this.expanded && this.expanded.docked) {
						this.expanded.collapse();
					}

					// remember this panel as expanded
					this.expanded = panel;
		}}
		// }}}
		// {{{
		// runs before panel collapses. Triggered by panel's beforecollapse event
		, beforecollapse: {
			  scope: this
			, fn: function(panel) {

				// raise panel if not docked
				if(!panel.docked) {
					this.raise(panel);
				}
				return this;
		}}
		// }}}
		// {{{
		// runs on when panel expands (before animation). Triggered by panel's expand event
		, expand: {
			  scope: this
			, fn: function(panel) {
				this.fireEvent('panelexpand', panel);
		}}
		// }}}
		// {{{
		// runs on when panel collapses (before animation). Triggered by panel's collapse event
		, collapse: {
		 	  scope: this
			, fn: function(panel) {
				this.fireEvent('panelcollapse', panel);
		}}
		// }}}
		// {{{
		// runs on when animation is completed. Triggered by panel's animationcompleted event
		, animationcompleted: {
			scope: this
			, fn: function(panel) {
				var box = panel.el.getBox();
				this.expandCount = (this.expandCount && this.expanding) ? --this.expandCount : 0;
				if((0 === this.expandCount) && this.expanding) {
//					this.setDockScroll(true);
					this.expanding = false;
				}
				this.fireEvent('panelbox', panel, box);
		}}
		// }}}
		// {{{
		// runs when panel is pinned. Triggered by panel's pinned event
		, pinned: {
			  scope: this
			, fn: function(panel, pinned) {
				if(!pinned) {
					if(panel.collapseOnUnpin) {
						panel.collapse();
					}
					else if(!this.independent) {
						this.items.each(function(p) {
							if(p !== panel && p.docked && !p.pinned) {
								p.collapse();
							}
						});
						this.expanded = panel;
					}
				}
				this.fireEvent('panelpinned', panel, pinned);
		}}
		// }}}

		, destroy: {
			scope:this
			, fn: function(panel) {
				this.items.removeKey(panel.id);
				this.updateOrder();
		}}
	});
	// }}}
	// {{{
	// add events
	this.addEvents({
		/**
			* Fires when a panel of the dock is collapsed
			* @event panelcollapse
			* @param {Ext.ux.InfoPanel} panel
			*/
		panelcollapse: true

		/**
			* Fires when a panel of the dock is expanded
			* @event panelexpand
			* @param {Ext.ux.InfoPanel} panel
			*/
		, panelexpand: true

		/**
			* Fires when a panel of the dock is pinned
			* @event panelpinned
			* @param {Ext.ux.InfoPanel} panel
			* @param {Boolean} pinned true if panel was pinned false if unpinned
			*/
		, panelpinned: true

		/**
			* Fires when the independent state of dock changes
			* @event independent
			* @param {Ext.ux.Accordion} this
			* @param {Boolean} independent New independent state
			*/
		, independent: true

		/**
			* Fires when the order of panel is changed
			* @event orderchange
			* @param {Ext.ux.Accordion} this
			* @param {Array} order New order array
			*/
		, orderchange: true

		/**
			* Fires when the undockable state of dock changes
			* @event undockable
			* @param {Ext.ux.Accordion} this
			* @param {Array} undockable New undockable state
			*/
		, undockable: true

		/**
			* Fires when a panel is undocked
			* @event panelundock
			* @param {Ext.ux.InfoPanel} panel
			* @param {Object} box Position and size object
			*/
		, panelundock: true

		/**
			* Fires when a panel is undocked
			* @event paneldock
			* @param {Ext.ux.InfoPanel} panel
			*/
		, paneldock: true

		/**
			* Fires when a panel box is changed, e.g. after dragging
			* @event panelbox
			* @param {Ext.ux.InfoPanel} panel
			* @param {Object} box Position and size object
			*/
		, panelbox: true
		
		/**
			* Fires when useShadow status changes
			* @event useshadow
			* @param {Ext.ux.Accordion} this
			* @param {Boolean} shadow Use shadow (for undocked panels) flag
			*/
		, useshadow: true
	});
	// }}}

	// setup body
	this.body = Ext.get(this.body) || this.el;
	this.resizeEl = this.body;
	this.id = this.el.id;
	this.body.addClass('x-dock-body');

	// setup desktop
	this.desktop = Ext.get(this.desktop || document.body);
	//this.desktop = this.desktop.dom || this.desktop;

	// setup fixed hight
	this.wrapEl = Ext.get(this.wrapEl);
	if(this.fitHeight) {
		this.body.setStyle('overflow', 'hidden');
//		this.bodyHeight = this.initialHeight || this.body.getHeight();
		//this.body.setHeight(this.initialHeight || this.body.getHeight());
		if(this.boxWrap && this.wrapEl) {
			this.wrapEl.boxWrap();
		}
	}

	// watch window resize
	if(this.monitorWindowResize) {
		Ext.EventManager.onWindowResize(this.adjustViewport, this);
	}

	// create drop zone for panels
	this.dd = new Ext.dd.DropZone(this.body.dom, {ddGroup:'dock-' + this.id });

}; // end of constructor

// extend
Ext.extend(Ext.ux.Accordion, Ext.ContentPanel, {

	// {{{
	// defaults
	independent: false
	, undockable: true
	, useShadow: true
	, boxWrap: false
	, fitHeight: false
	, initialHeight: 0
	, animate: true // global animation flag
	, zindex: 9999 // (private)
	, zindexInc: 2 // (private) one for shadow
	, expandCount: 0
	, expanding: false
	, monitorWindowResize: true
	, resizable: true // global resizable flag
	, draggable: true // global draggable flag
	// }}}
	// {{{
	/**
		* Adds the panel to Accordion
		* @param {Ext.ux.InfoPanel} panel Panel to add
		* @return {Ext.ux.InfoPanel} added panel
		*/
	, add: function(panel) {


		// append panel to body
		this.body.appendChild(panel.el);

		panel.docked = true;

		// add docked class to panel body
//		panel.body.addClass('x-dock-panel-body-docked');
//		panel.body.removeClass('x-dock-panel-body-undocked');
		panel.body.replaceClass('x-dock-panel-body-undocked', 'x-dock-panel-body-docked');

		// add panel to items collection
		this.items.add(panel.el.id, panel);

		// relay these events from panel to dock
		this.relayEvents(panel, [
			'beforecollapse'
			, 'collapse'
			, 'beforeexpand'
			, 'expand'
			, 'animationcompleted'
			, 'pinned'
			, 'boxchange'
			, 'destroy'
		]);

		// panel dragging 
		if(this.draggable) {
			panel.dd = new Ext.ux.Accordion.DDDock(panel, 'dock-' + this.id, this);
		}

		// panel resizing
		panel.resizable = this.resizable;
//		panel.setResizable(this.resizable);

		// shadow and animate flags
		panel.useShadow = this.useShadow;
		panel.setShadow(this.useShadow);
		if(panel.shadow) {
			panel.shadow.hide();
		}
		panel.animate = undefined === panel.animate ? this.animate : panel.animate;

		// z-index for panel
		this.zindex += this.zindexInc;
		panel.zindex = this.zindex;

		// onclick handler for panel body (allows raising when panel body is clicked)
		panel.body.on('click', this.onClickPanelBody.createDelegate(this, [panel]));

		if(this.fitHeight) {
			this.setPanelHeight(panel);
		}

		panel.dock = this;
		panel.desktop = this.desktop;

		return panel;

	}
	// }}}
	// {{{
	/**
		* Called internally to raise panel above others
		* Maintains z-index stack
		* @param {Ext.ux.InfoPanel} panel Panel to raise
		*/
	, raise: function(panel) {
		this.items.each(function(p) {
			if(p.zindex > panel.zindex) {
				p.zindex -= this.zindexInc;
				p.el.applyStyles({'z-index':p.zindex});
				if(!p.docked) {
					p.setShadow(true);
				}
			}
		}, this);
		panel.zindex = this.zindex;
		panel.el.applyStyles({'z-index':panel.zindex});
		if(this.desktop.lastChild !== panel.el.dom) {
			this.desktop.appendChild(panel.el.dom);
		}
		if(!panel.docked) {
			panel.setShadow(true);
		}
	}
	// }}}
	// {{{
	/**
		* Resets the order of panels within the dock
		*
		* @return {Ext.ux.Accordion} this
		*/
	, resetOrder: function() {
		this.items.each(function(panel) {
			if(!panel.docked) {
				return;
			}
			this.body.appendChild(panel.el);
		}, this);
		this.updateOrder();
		return this;
	}
	// }}}
	// {{{
	/**
		* Called internally to update the order variable after dragging
		*/
	, updateOrder: function() {
		var order = [];
		var titles = this.body.select('.x-layout-panel-hd');
		titles.each(function(titleEl){
			order.push(titleEl.dom.parentNode.id);
		});
		this.order = order;
		this.fireEvent('orderchange', this, order);
	}
	// }}}
	// {{{
	/**
		* Returns array of panel ids in the current order
		* @return {Array} order of panels
		*/
	, getOrder: function() {
		return this.order;
	}
	// }}}
	// {{{
	/**
		* Set the order of panels
		* @param {Array} order Array of ids of panels in required order.
		* @return {Ext.ux.Accordion} this
		*/
	, setOrder: function(order) {
		if('object' !== typeof order || undefined === order.length) {
			throw "setOrder: Argument is not array.";
		}
		var panelEl;
		for(var i = 0; i < order.length; i++) {
			panelEl = Ext.get(order[i]);
			if(panelEl) {
				this.body.appendChild(panelEl);
			}
		}
		this.updateOrder();
		return this;
	}
	// }}}
	// {{{
	/**
		* Collapse all docked panels
		* @param {Boolean} alsoPinned true to first unpin then collapse
		* @param {Ext.ux.InfoPanel} except This panel will not be collapsed.
		* @return {Ext.ux.Accordion} this
		*/
	, collapseAll: function(alsoPinned, except) {
		this.items.each(function(panel) {
			if(panel.docked) {
				panel.pinned = alsoPinned ? false : panel.pinned;
				if(!except || panel !== except) {
					panel.collapse();
				}
			}
		}, this);
		return this;
	}
	// }}}
	// {{{
	/**
		* Expand all docked panels in independent mode
		* @return {Ext.ux.Accordion} this
		*/
	, expandAll: function() {
		if(this.independent) {
			this.items.each(function(panel) {
				if(panel.docked && panel.collapsed) {
					panel.expand();
				}
			}, this);
		}
	}
	// }}}
	// {{{
	/**
		* Called internally while dragging and by state manager
		* @param {Ext.ux.InfoPanel/String} panel Panel object or id of the panel
		* @box {Object} box coordinates with target position and size
		* @return {Ext.ux.Accordion} this
		*/
	, undock: function(panel, box) {

		// get panel if necessary
		panel = 'string' === typeof panel ? this.items.get(panel) : panel;

		// proceed only if we have docked panel and in undockable mode
		if(panel && panel.docked && this.undockable) {

			// sanity check
			if(box.x < 0 || box.y < 0) {
				return this;
			}

			// move the panel in the dom (append to desktop)
			this.desktop.appendChild(panel.el.dom);

			// adjust panel visuals
			panel.el.applyStyles({
				position:'absolute'
				, 'z-index': panel.zindex
			});
			panel.body.replaceClass('x-dock-panel-body-docked', 'x-dock-panel-body-undocked');

			// position the panel
			panel.setBox(box);

			// reset docked flag
			panel.docked = false;

			// hide panel shadow (will be shown by raise)
			if(panel.shadow) {
				panel.shadow.hide();
			}

			// raise panel above others
			this.raise(panel);

			// set the height of a docked expanded panel
			this.setPanelHeight(this.expanded);

			// enable resizing and scrolling
			panel.setResizable(!panel.collapsed);
			if(panel.bodyScroll) {
				panel.body.setStyle('overflow','auto');
			}

			// size the undocked panel
			// todo: revise
			panel.lastWidth = box.width;
			panel.lastHeight = box.height;

			// fire panelundock event
			this.fireEvent('panelundock', panel, {x:box.x, y:box.y, width:box.width, height:box.height});
		}

		return this;
	}
	// }}}
	// {{{
	/**
		* Called internally while dragging 
		* @param {Ext.ux.InfoPanel/String} panel Panel object or id of the panel
		* @param {String} targetId id of panel after which this panel will be docked
		* @return {Ext.ux.Accordion} this
		*/
	, dock: function(panel, targetId) {

		// get panel if necessary
		panel = 'string' === typeof panel ? this.items.get(panel) : panel;

		// proceed only if we have a docked panel
		if(panel && !panel.docked) {

			// remember width and height
			if(!panel.collapsed) {
				panel.lastWidth = panel.el.getWidth();
				panel.lastHeight = panel.el.getHeight();
			}

			// move the panel element in the dom
			if(targetId && (this.body.id !== targetId)) {
				panel.el.insertBefore(Ext.fly(targetId));
			}
			else {
				panel.el.appendTo(this.body);
			}

			// set docked flag
			panel.docked = true;

			// adjust panel visuals
			panel.body.replaceClass('x-dock-panel-body-undocked', 'x-dock-panel-body-docked');
			panel.el.applyStyles({
				top:''
				, left:''
				, width:''
				, height:''
				, 'z-index':''
				, position:'relative'
				, visibility:''
			});
			panel.body.applyStyles({width:'',height:''});

			// disable resizing and shadow
			panel.setResizable(false);
			if(panel.shadow) {
				panel.shadow.hide();
			}

			// set panel height (only if this.fitHeight = true)
			this.setPanelHeight(panel.collapsed ? this.expanded : panel);

			// fire paneldock event
			this.fireEvent('paneldock', panel);
		}

		return this;
	}
	// }}}
	// {{{
	/**
		* Sets the independent mode
		* @param {Boolean} independent set to false for normal mode
		* @return {Ext.ux.Accordion} this
		*/
	, setIndependent: function(independent) {
		this.independent = independent ? true : false;
		this.fireEvent('independent', this, independent);
		return this;
	}
	// }}}
	// {{{
	/**
		* Sets the undockable mode 
		* If undockable === true all undocked panels are docked and collapsed (except pinned)
		* @param {Boolean} undockable set to true to not allow undocking
		* @return {Ext.ux.Accordion} this
		*/
	, setUndockable: function(undockable) {
		this.items.each(function(panel) {

			// dock and collapse (except pinned) all undocked panels if not undockable
			if(!undockable && !panel.docked) {
				this.dock(panel);
				if(!this.independent && !panel.collapsed && !panel.pinned) {
					panel.collapse();
				}
			}

			// refresh dragging constraints
			if(panel.docked && panel.draggable) {
				panel.dd.constrainTo(this.body, 0, false);
				panel.dd.clearConstraints();
				if(undockable) {
					panel.constrainToDesktop();
				}
				else {
					panel.dd.setXConstraint(0,0);
				}
			}
		}, this);

		// set the flag and fire event
		this.undockable = undockable;
		this.fireEvent('undockable', this, undockable);
		return this;
	}
	// }}}
	// {{{
	/**
		* Restores state of dock and panels
		* @param {Ext.state.Provider} provider (optional) An alternate state provider
		*/
	, restoreState: function(provider) {
		if(!provider) {
			provider = Ext.state.Manager;
		}
		var sm = new Ext.ux.AccordionStateManager();
		sm.init(this, provider);

	}
	// }}}
	// {{{
	/**
		* Sets the shadows for all panels
		* @param {Boolean} shadow set to false to disable shadows
		* @return {Ext.ux.Accordion} this
		*/
	, setShadow: function(shadow) {
		this.items.each(function(panel) {
			panel.useShadow = shadow;
			panel.setShadow(false);
			if(!panel.docked) {
				panel.setShadow(shadow);
			}
		});
		this.useShadow = shadow;
		this.fireEvent('useshadow', this, shadow);
		return this;
	}
	// }}}
// {{{
	/**
		* Called when user clicks the panel body
		* @param {Ext.ux.InfoPanel} panel
		*/
	, onClickPanelBody: function(panel) {
		if(!panel.docked) {
			this.raise(panel);
		}
	}
// }}}
	// {{{
	/**
		* Called internally for fixed height docks to get current height of panel(s)
		*/
	, getPanelBodyHeight: function() {
			var titleHeight = 0;
			this.items.each(function(panel) {
				titleHeight += panel.docked ? panel.titleEl.getHeight() : 0;
			});
			this.panelBodyHeight = this.body.getHeight() - titleHeight - this.body.getFrameWidth('tb') + 1;
//			this.panelBodyHeight = this.body.getHeight() - titleHeight - this.body.getFrameWidth('tb');
			return this.panelBodyHeight;
	}
	// }}}
	// {{{
	/**
		* Sets the height of panel body 
		* Used with fixed height (fitHeight:true) docs
		* @param {Ext.ux.InfoPanel} panel (defaults to this.expanded)
		* @return {Ext.ux.Accordion} this
		*/
	, setPanelHeight: function(panel) {
		panel = panel || this.expanded;
		if(this.fitHeight && panel && panel.docked) {
			panel.body.setHeight(this.getPanelBodyHeight());
		}
		return this;
	}
	// }}}
	// {{{
	/**
		* Constrains the dragging of panels do the desktop
		* @return {Ext.ux.Accordion} this
		*/
	, constrainToDesktop: function() {
		this.items.each(function(panel) {
			panel.constrainToDesktop();
		}, this);
		return this;
	}
	// }}}
	// {{{
	/** 
		* Clears dragging constraints of panels
		* @return {Ext.ux.Accordion} this
		*/
	, clearConstraints: function() {
		this.items.each(function(panel) {
			panel.dd.clearConstraints();
		});
	}
	// }}}
	// {{{
	/**
		* Shows all panels
		* @param {Boolean} show (optional) if false hides the panels instead of showing
		* @param {Boolean} alsoUndocked show also undocked panels (defaults to false)
		* @return {Ext.ux.Accordion} this
		*/
	, showAll: function(show, alsoUndocked) {
		show = (false === show ? false : true);
		this.items.each(function(panel) {
			panel.show(show, alsoUndocked);
		});
		return this;
	}
	// }}}
	// {{{
	/**
		* Hides all panels
		* @param {Boolean} alsoUndocked hide also undocked panels (defaults to false)
		* @return {Ext.ux.Accordion} this
		*/
	, hideAll: function(alsoUndocked) {
		return this.showAll(false, alsoUndocked);
	}
	// }}}
	// {{{
	/**
		* Called internally to disable/enable scrolling of the dock while animating
		* @param {Boolean} enable true to enable, false to disable
		* @return {void}
		* @todo not used at present - revise
		*/
	, setDockScroll: function(enable) {
		if(enable && !this.fitHeight) {
			this.body.setStyle('overflow','auto');
		}
		else {
			this.body.setStyle('overflow','hidden');
		}
	}
	// }}}
	// {{{
	/**
		* Set Accordion size
		* Overrides ContentPanel.setSize
		*
		* @param {Integer} w width
		* @param {Integer} h height
		* @return {Ext.ux.Accordion} this
		*/
	, setSize: function(w, h) {
		// call parent's setSize
		Ext.ux.Accordion.superclass.setSize.call(this, w, h);
//		this.body.setHeight(h);
		this.setPanelHeight();

		return this;
	}
	// }}}
	// {{{
	/** 
		* Called as windowResize event handler
		*
		* @todo: review
		*/
	, adjustViewport: function() {
		var viewport = this.desktop.dom === document.body ? {} : Ext.get(this.desktop).getBox();

		viewport.height = 
			this.desktop === document.body 
			? window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight
			: viewport.height
		;

		viewport.width = 
			this.desktop === document.body 
			? window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth
			: viewport.width
		;

		viewport.x = this.desktop === document.body ? 0 : viewport.x;
		viewport.y = this.desktop === document.body ? 0 : viewport.y;

		this.items.each(function(panel) {
			if(!panel.docked) {
				panel.moveToViewport(viewport);
			}
		});

	}
	// }}}

}); // end of extend

// {{{
// {{{
/**
	* @class Ext.ux.Accordion.DDDock
	* @constructor
	* @extends Ext.dd.DDProxy
	* @param {Ext.ux.InfoPanel} panel Panel the dragging object is created for
	* @param {String} group Only elements of same group interact
	* @param {Ext.ux.Accordion} dock Place where panels are docked/undocked
	*/
Ext.ux.Accordion.DDDock = function(panel, group, dock) {

	// call parent constructor
	Ext.ux.Accordion.DDDock.superclass.constructor.call(this, panel.el.dom, group);

	// save panel and dock references for use in methods
	this.panel = panel;
	this.dock = dock;

	// drag by grabbing the title only
	this.setHandleElId(panel.titleEl.id);

	// move only in the dock if undockable
	if(false === dock.undockable) {
		this.setXConstraint(0, 0);
	}

	// init internal variables
	this.lastY = 0;

	//this.DDM.mode = Ext.dd.DDM.INTERSECT;
	this.DDM.mode = Ext.dd.DDM.POINT;

}; // end of constructor
// }}}

// extend
Ext.extend(Ext.ux.Accordion.DDDock, Ext.dd.DDProxy, {

	// {{{
	/**
		* Default DDProxy startDrag override
		* Saves some variable for use by other methods 
		* and creates nice dragging proxy (ghost)
		*
		* Passed x, y arguments are not used
		*/
	startDrag: function(x, y) {

		this.lastMoveTarget = null;

		// create nice dragging ghost
		this.createGhost();

		// get srcEl (the original) and dragEl (the ghost)
		var srcEl = Ext.get(this.getEl());
		var dragEl = Ext.get(this.getDragEl());

		// refresh constraints
		this.panel.constrainToDesktop();
		var dragHeight, rightC, bottomC;
		if(this.dock.undockable) {
			if(this.panel.collapsed) {
				dragHeight = this.panel.titleEl.getHeight();
			}
			else {
				dragHeight = dragEl.getHeight();
				dragHeight = dragHeight <= this.panel.titleEl.getHeight() ? srcEl.getHeight() : dragHeight;
			}

			rightC = this.rightConstraint + srcEl.getWidth() - dragEl.getWidth();
			bottomC = this.bottomConstraint + srcEl.getHeight() - dragHeight;
			this.setXConstraint(this.leftConstraint, rightC);
			this.setYConstraint(this.topConstraint, bottomC);
		}
		else {
			if(this.panel.docked) {
				this.setXConstraint(0, 0);
			}
		}

		// hide dragEl (will be shown by onDrag)
		dragEl.hide();

		// raise panel's "window" above others
		if(!this.panel.docked) {
			this.dock.raise(this.panel);
		}

		// hide panel's shadow if any
		this.panel.setShadow(false);

		// clear visibility of panel's body (was setup by animations)
		this.panel.body.dom.style.visibility = '';

		// hide source panel if undocked
		if(!this.panel.docked) {
			srcEl.hide();
			dragEl.show();
		}

	} // end of function startDrag
	// }}}
	// {{{
	/**
		* Called internally to create nice dragging proxy (ghost)
		*/
	, createGhost: function() {

		// get variables
		var srcEl = Ext.get(this.getEl());
		var dragEl = Ext.get(this.getDragEl());
		var dock = this.dock;
		var panel = this.panel;

		// adjust look of ghost
		dragEl.addClass('x-dock-panel-ghost');
		dragEl.applyStyles({border:'1px solid #84a0c4','z-index': dock.zindex + dock.zindexInc});

		// set size of ghost same as original
		dragEl.setBox(srcEl.getBox());
		if(panel.docked) {
			if(panel.lastWidth && dock.undockable) {
				dragEl.setWidth(panel.lastWidth);
			}
			if(!panel.collapsed && dock.undockable && (panel.lastHeight > panel.titleEl.getHeight())) {
				dragEl.setHeight(panel.lastHeight);
			}
		}

		// remove unnecessary text nodes from srcEl
		srcEl.clean();

		// setup title
		var dragTitleEl = Ext.DomHelper.append(dragEl, {tag:'div'}, true);
		dragTitleEl.update(srcEl.dom.firstChild.innerHTML);
		dragTitleEl.dom.className = srcEl.dom.firstChild.className;
		if(panel.collapsed && Ext.isIE) {
			dragTitleEl.dom.style.borderBottom = "0";
		}

	} // end of function createGhost
	// }}}
	// {{{
	/**
		* Default DDProxy onDragOver override
		* It is called when dragging over a panel
		* or over the dock.body DropZone
		*
		* @param {Event} e not used
		* @param {String} targetId id of the target we're over
		*
		* Beware: While dragging over docked panels it's called
		* twice. Once for panel and once for DropZone
		*/
	, onDragOver: function(e, targetId) {

		this.currentTarget = targetId;

		// save targetId for use by endDrag
		this.lastTarget = targetId;

		// get panel element
		var srcEl = Ext.get(this.getEl());

		// get target panel
		var targetPanel = this.dock.items.get(targetId);

		// landing indicators
		if(targetPanel) {
			if(targetPanel.docked && (targetPanel.collapsed || !this.panel.docked)) {
				targetPanel.titleEl.addClass('x-dock-panel-title-dragover');
			}
		}
		else {
			if(!this.panel.docked) {
				this.dock.body.addClass('x-dock-body-dragover');
			}
			else {
				this.panel.titleEl.addClass('x-dock-panel-title-dragover');
			}
		}

		// do nothing else if we're not over another docked panel
		if(!targetPanel || !targetPanel.docked) {
			return;
		}

		// reorder panels in dock if we're docked too
		var targetEl;
		if(this.panel.docked) {
			targetEl = targetPanel.el;

			if(targetPanel.collapsed || this.lastMoveTarget !== targetPanel) {
				if(this.movingUp) {
					srcEl.insertBefore(targetEl);
					this.lastMoveTarget = targetPanel;
				}
				else {
					srcEl.insertAfter(targetEl);
					this.lastMoveTarget = targetPanel;
				}
			}
			this.DDM.refreshCache(this.groups);
		}

	} // end of function onDragOver
	// }}}
	// {{{
	/**
		* Called internally when cursor leaves a drop target
		* @param {Ext.Event} e
		* @param {String} targetId id of target we're leaving
		*/
	, onDragOut: function(e, targetId) {

		var targetPanel = this.dock.items.get(targetId);

		if(!targetPanel) {
			this.dock.body.removeClass('x-dock-body-dragover');
			if(this.dock.body.id === targetId) {
				this.panel.titleEl.removeClass('x-dock-panel-title-dragover');
			}
		}
		else {
			targetPanel.titleEl.removeClass('x-dock-panel-title-dragover');
		}
		this.currentTarget = null;
	}
	// }}}
	// {{{
	/**
		* Default DDProxy onDrag override
		*
		* It's called while dragging
		* @param {Event} e used to get coordinates
		*/
	, onDrag: function(e) {

		// get source (original) and proxy (ghost) elements
		var srcEl = Ext.get(this.getEl());
		var dragEl = Ext.get(this.getDragEl());

		if(!dragEl.isVisible()) {
			dragEl.show();
		}

		var y = e.getPageY();

		this.movingUp = this.lastY > y;
		this.lastY = y;

	} // end of function onDrag
	// }}}
	// {{{
	/**
		* Default DDProxy endDrag override
		*
		* Called when dragging is finished
		*/
	, endDrag: function() {

		// get the source (original) and proxy (ghost) elements
		var srcEl = Ext.get(this.getEl());
		var dragEl = Ext.get(this.getDragEl());

		// get box and hide the ghost
		var box = dragEl.getBox();

		// remove any dragover classes from panel title and dock
		this.panel.titleEl.removeClass('x-dock-panel-title-dragover');
		this.dock.body.removeClass('x-dock-body-dragover');

		var targetPanel = this.dock.items.get(this.currentTarget);

		// undock (docked panel dropped out of dock)
		if((this.panel.docked && !this.currentTarget) || (targetPanel && !targetPanel.docked)) {
			this.dock.undock(this.panel, box);
		}

		// dock (undocked panel dropped on dock)
		else if(this.currentTarget) {
			if(targetPanel) {
				targetPanel.titleEl.removeClass('x-dock-panel-title-dragover');
			}
			else {
				this.dock.body.removeClass('x-dock-body-dragover');
			}
			this.dock.dock(this.panel, this.currentTarget);
		}

		// just free dragging
		if(!this.panel.docked) {
			this.panel.setBox(box);
			srcEl.show();
		}

		// clear the ghost content, hide id and move it off screen
		dragEl.hide();
		dragEl.update('');
		dragEl.applyStyles({
			top:'-9999px'
			, left:'-9999px'
			, height:'0px'
			, width:'0px'
		});

		// update order of docked panels
		this.dock.updateOrder();

		// repair the expanded/collapsed states of panels in the dock
		if(!this.panel.collapsed && !this.dock.independent && this.panel.docked) {
			this.dock.collapseAll(false, this.panel);
			this.dock.expanded = this.panel;
		}

		// let the state manager know the new panel position
		this.dock.fireEvent('panelbox', this.panel, {x:box.x, y:box.y, width:box.width, height:box.height});

	} // end of function endDrag
	// }}}

});
// }}}
// {{{
/**
	* Private class for keeping and restoring state of the Accordion
	*/
Ext.ux.AccordionStateManager = function(dock) {
	this.state = {
		dock: {}
		, panels: {}
	};
};

Ext.ux.AccordionStateManager.prototype = {

	// {{{
	init: function(dock, provider) {
		this.provider = provider;
		var panel;
		var state = provider.get(dock.id + '-dock-state');
		if(state) {

			// {{{
			// handle dock
			if(undefined !== state.dock.independent) {
				dock.setIndependent(state.dock.independent);
			}

			if(undefined !== state.dock.undockable) {
				dock.setUndockable(state.dock.undockable);
			}

			if(undefined !== state.dock.useShadow) {
				dock.setShadow(state.dock.useShadow);
			}

			if('object' === typeof state.dock.order && state.dock.order.length) {
				dock.setOrder(state.dock.order);
			}
			// }}}
			// {{{
			// handle panels
			for(var panelId in state.panels) {
				panel = dock.items.get(panelId);
				if(panel) {
					// {{{
					// we need collapsed state early
					panel.collapsed = 
						(undefined === typeof state.panels[panelId].collapsed)
						? true
						: state.panels[panelId].collapsed
					;
					// }}}
					// {{{
					// handle docked/undocked
					if(undefined !== typeof state.panels[panelId].docked) {
						if(!state.panels[panelId].docked && 'object' === typeof state.panels[panelId].box) {
							dock.undock(panel, state.panels[panelId].box);
						}
						panel.docked = state.panels[panelId].docked;
					}
					// }}}
					// {{{
					// handle pinned state
					if(undefined !== typeof state.panels[panelId].pinned) {
						panel.pinned = state.panels[panelId].pinned;
					}
					// }}}
					// {{{
					// handle collapsed state
					if(panel.collapsed) {
						panel.collapse();
					}
					else {
						if(!dock.expanded || dock.independent || panel.pinned || !panel.docked) {
							panel.body.show();
							panel.collapsed = false;
							if(!panel.pinned && panel.docked) {
								dock.expanded = panel;
							}
							panel.updateVisuals();
						}
					}
					// }}}

				}
			}
			// }}}

//			dock.setSize(dock.body.getWidth(), dock.body.getHeight());
			dock.setPanelHeight(dock.expanded);

			this.state = state;
		}
		this.dock = dock;

		// install event handlers on dock
		dock.on({
			panelcollapse: {scope: this, fn: this.onPanelCollapse}
			, panelexpand: {scope: this, fn: this.onPanelCollapse}
			, panelpinned: {scope: this, fn: this.onPanelPinned}
			, independent: {scope: this, fn: this.onIndependent}
			, orderchange: {scope: this, fn: this.onOrderChange}
			, undockable: {scope: this, fn: this.onUndockable}
			, paneldock: {scope: this, fn: this.onPanelUnDock}
			, panelundock: {scope: this, fn: this.onPanelUnDock}
			, panelbox: {scope: this, fn: this.onPanelUnDock}
			, boxchange: {scope: this, fn: this.onPanelUnDock}
			, useshadow: {scope: this, fn: this.onUseShadow}
		});

	}
	// }}}
	// {{{
	, onPanelCollapse: function(panel) {
		this.state.panels[panel.id] = this.state.panels[panel.id] || {};
		this.state.panels[panel.id].collapsed = panel.collapsed;
		this.storeState();
	}
	// }}}
	// {{{
	, onPanelPinned: function(panel, pinned) {
		this.state.panels[panel.id] = this.state.panels[panel.id] || {};
		this.state.panels[panel.id].pinned = pinned;
		this.storeState();
	}
	// }}}
	// {{{
	, onPanelUnDock: function(panel, box) {
		this.state.panels[panel.id] = this.state.panels[panel.id] || {};
		this.state.panels[panel.id].docked = panel.docked;
		this.state.panels[panel.id].box = box || null;
		this.storeState();
	}
	// }}}
	// {{{
	, onIndependent: function(dock, independent) {
		this.state.dock.independent = independent;
		this.storeState();
	}
	// }}}
	// {{{
	, onOrderChange: function(dock, order) {
		this.state.dock.order = order;
		this.storeState();
	}
	// }}}
	// {{{
	, onUndockable: function(dock, undockable) {
		this.state.dock.undockable = undockable;
		this.storeState();
	}
	// }}}
	// {{{
	, onUseShadow: function(dock, shadow) {
		this.state.dock.useShadow = shadow;
		this.storeState();
	}
	// }}}
	// {{{
	, storeState: function() {
		this.provider.set.defer(700, this, [this.dock.id + '-dock-state', this.state]);
	}
	// }}}

}; // end of Ext.ux.AccordionStateManager.prototype
// }}}

// end of file
