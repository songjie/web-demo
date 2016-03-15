<script>
(function(w) {
    'use strict';

    [ 1, 2, 3, 4, 5 ].every(function(element, index, arr) {
        w.log(element + ' at index ' + index + ' in array ' + arr);

        if (index !== 5) {
            return true;
        }
    });

    // Defining a simple javascript object
    var obj = {
        a : 'A',
        b : 'B',
        'c-d-e' : 'CDE'
    };

    // Iterating over the object keys
    Object.keys(obj).forEach(function(element, index, arr) {
        w.log('Key ' + element + ' has value ' + obj[element]);
    });
}(window.console));
</script>
<style>
.text-box:before {
  content: "";
  display: inline-block;
  width: 1rem;
  height: 1rem;
  background: url(/images/tree.png) no-repeat;
  background-size: 100%;
}
</style>
<span class="text-box">
  See the square next to me?
</span>