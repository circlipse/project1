
	document.querySelector(".bag").disabled = true;
	
function del1() {
    var del_val = document.getElementById("bagg1");
    del_val.remove();
    sumprice();
    document.querySelector('#bag1').removeAttribute("disabled");
    document.querySelector('.bag').value="";
    
}

function del2() {
    var del_val = document.getElementById("bagg2");
    del_val.remove();
    sumprice();
    document.querySelector('#bag2').removeAttribute("disabled");
    document.querySelector('.bag').value="";
    
}
function getbagprice_1(){
    if(document.getElementsByName('bag_val_1')[0] == null){
        let bag_price_1=0;
        return bag_price_1;
    }else{
        let num_val_1=parseInt(document.getElementsByName('bag_val_1')[0].value);
        let bag_price_1=num_val_1 * 15000;
        return bag_price_1;
    }   
}
function getbagprice_2(){
    if(document.getElementsByName('bag_val_2')[0] == null){
        let bag_price_2=0;
        return bag_price_2;
    }else{
        let num_val_2=parseInt(document.getElementsByName('bag_val_2')[0].value);
        let bag_price_2=num_val_2 * 10000;
        return bag_price_2;
    }
}

function sumprice(){
    
    let sum_bag_price_1=getbagprice_1();
    let sum_bag_price_2=getbagprice_2();

    document.getElementById('price').value=sum_bag_price_1+sum_bag_price_2;

}
console.log(document.getElementsByTagName("td").length);
//document.getElementById('price').value=0;
	
	const selectElement = document.querySelector('.bag');
	selectElement.addEventListener('change', (event) =>{
			
		let vtd1 = document.createElement('td');
		let txt1 = document.createTextNode(event.target.value);
		
		if(event.target.value=='캐리어'){
			vtd1.setAttribute('id', 'bagg1');
			
		} else{
			vtd1.setAttribute('id', 'bagg2');
			
		}
		
		let val = document.createElement('input');
		val.setAttribute('type', 'number');
		val.setAttribute('min', '1');
	    val.setAttribute('max', '20');
	    val.setAttribute('id', 'val');
	    val.setAttribute('value', '1');
	    
	    let button = document.createElement('button');
	    button.setAttribute('type', 'button')
	    button.setAttribute('id', 'delete');
	    if(event.target.value=='캐리어'){
	    button.setAttribute('onclick', 'del1()');
	    } else{
	    button.setAttribute('onclick', 'del2()');
	    } 
	    let buttontxt = document.createTextNode('삭제');
		
	    button.append(buttontxt);
	    vtd1.append(txt1);
	    vtd1.append(val);
	    vtd1.append(button);
	    
	    if(event.target.value=='캐리어'){
	    document.querySelector('.result1').appendChild(vtd1);
	    } else{
	    document.querySelector('.result2').appendChild(vtd1);
	    }
	    
		console.log(document.getElementsByTagName("td").length);
	    if (document.getElementsByTagName("td").length > 20) {
	    	document.querySelector('#bag1').disabled = true;
	        document.querySelector('#bag2').disabled = true;
	    }
		
	    if(event.target.value=="캐리어"){
	    	val.setAttribute('name', 'bag_val_1');
			sumprice();
        val.setAttribute('onchange', 'sumprice()');
	    } else{
	    	val.setAttribute('name', 'bag_val_2');
			sumprice();
			val.setAttribute('onchange', 'sumprice()');
	    }
		
	});