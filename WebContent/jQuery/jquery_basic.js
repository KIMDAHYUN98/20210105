/*jquery_basic.js*/

console.log('first');
	$(document).ready(function() {
		console.log('second');
		console.log(document.getElementById('food_1').childNodes[1].firstChild.nodeValue); //childNodes[0] = firstChild
		console.log($('#food_1').children().eq(0).html()); // eq(0) = 인덱스 위치, html = innerHTML
		$('#food_1 > ul > li').eq(0).css('background', 'red');
		$('#food_1 > ul > li').eq(1).html('bulgogi');
	});
	console.log('third');