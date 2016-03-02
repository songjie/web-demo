(function($) {
	"use strict";
	
	$.views.helpers({
		now : function() {
			return moment().format('YYYY-MM-DD');
		},
		addDays: function(days) {
			return moment().add(days, 'days').format('YYYY-MM-DD');
		}
	})
})(jQuery);