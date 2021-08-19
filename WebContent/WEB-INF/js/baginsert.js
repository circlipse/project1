
function del1() {
    var del_val = document.getElementById("bagg1");
    del_val.remove();
    document.querySelector(".bag").disabled = false;
}

function del2() {
    var del_val = document.getElementById("bagg2");
    del_val.remove();
    document.querySelector(".bag").disabled = false;
}

const selectElement = document.querySelector('.bag');
selectElement.addEventListener('change', (event) => {
	
    let vli1 = document.createElement('li');
    
    if(event.target.value=='캐리어'){
    	vli1.setAttribute('id', 'bagg1');
    } else{
    	vli1.setAttribute('id', 'bagg2');
    }
    
    let txt1 = document.createTextNode(event.target.value);
   
    let val = document.createElement('input');
    val.setAttribute('type', 'number');
    val.setAttribute('min', '1');
    val.setAttribute('max', '20');
    val.setAttribute('id', 'val');
    val.setAttribute('value', '1');
 
    //삭제버튼
    let button = document.createElement('button');
    button.setAttribute('type', 'button');
    button.setAttribute('id', 'delete');
    if(event.target.value=='캐리어'){
    	button.setAttribute('onclick', 'del1()');
    } else{
    	button.setAttribute('onclick', 'del2()');
    }
    let buttontxt = document.createTextNode('삭제');

    button.append(buttontxt);
    vli1.append(txt1);
    vli1.append(val);
    vli1.append(button);
    
    if(event.target.value=='캐리어'){
    	document.querySelector('.result1').appendChild(vli1);
    } else{
    	document.querySelector('.result2').appendChild(vli1);
    }
    
    if (document.getElementsByTagName("li").length > 9) {
        document.querySelector(".bag").disabled = true;
    }
    
    if(event.target.value=="캐리어"){
    	val.setAttribute('name', 'bag_val_1');
    } else if(event.target.value=="백팩"){
    	val.setAttribute('name', 'bag_val_2');
    }
});

