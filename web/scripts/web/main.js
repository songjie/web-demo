(function($) {
	Class('com.Main', {
		init: function(options) {
			var _this = this;
			_this._options = $.extend({
				id: 'main',
				template: '{{search /}}',
				content: {}
			}, options);
			_this._id = '#' + _this._options.id;
			_this._template = $.templates(_this._options.template);
			_this._content = _this._options.content;
		},
		initContext: function() {
			var _this = this;
			_this._template.link(_this._id, _this._content);
		}
	})
})(jQuery);
	