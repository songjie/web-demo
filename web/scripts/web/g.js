// global space
var g = function() {
}
// name space
g.namespace = function(b) {
	var i;
	var c, a, d, e, f;
	c = window;
	a = b.split(".");
	if (!b)
		return c;
	for (b = d = 0, e = a.length; 0 <= e ? d < e : d > e; b = 0 <= e ? ++d
			: --d)
		c[a[b]] = c[a[b]] || {}, i = (f = c[a[b]]) != null ? f : {}, c = i;
	return c
};
// com namespace
g.namespace('com');


main = new com.Main({content:{say:'hello', name: 'world', datetime: "20151229"}});
main.initContext();