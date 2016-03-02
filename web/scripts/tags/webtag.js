(function($) {
	"use strict";

	$.views.tags({
		search : {
			init :function(tagCtx) {
				var _this = this;
				tagCtx.view.data.msg = tagCtx.view.data.say + "," + tagCtx.view.data.name;
				_this.template = '#mainTemplate';
			}
		}
	})
})(jQuery);