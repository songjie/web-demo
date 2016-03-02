(function($) {
	"use strict";
	
	$.views.converters({
		date : function(date) {
			if (date && date != null) {
				var parse = this.tagCtx.props.parse;
				var format = this.tagCtx.props.format;
				var utc = this.tagCtx.props.utc;
				format = format ? format : 'YYYY-MM-DD HH:mm:ss';
				utc = utc ? utc : '+09:00';
				var dt;
				if (parse) {
					dt = moment(date, parse);
				} else {
					dt = moment(date)
				}
				return dt.utcOffset(utc).format(format);
			}
			return '';
		}
	})
})(jQuery);