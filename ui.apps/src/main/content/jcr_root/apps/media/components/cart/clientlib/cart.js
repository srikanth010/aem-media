
$(document).ready(function() {
    let count = 0;
    $("a.add-to-cart").click(function(event) {
        count++;
        setTimeout(function() {
            $("a").find("span").addClass("counter");
            $("a").find("span").text(count);
            console.log($("a.cart_add > span").addClass("counter"));
        }, 200);
        event.preventDefault();
    });
});