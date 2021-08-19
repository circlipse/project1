
	document.querySelector(".bag").disabled = true;
	

	function del() {
	    var del_val = document.getElementById("bagg");
	    del_val.remove();
	    document.querySelector(".bag").disabled = false;
	}
	
	const selectElement = document.querySelector('.bag');
	selectElement.addEventListener('change', (event) =>{
		

		
		let vtd1 = document.createElement('td');
		vtd1.setAttribute('id', 'bagg');
		let txt1 = document.createTextNode(event.target.value);
		
		let val = document.createElement('input');
		val.setAttribute('type', 'number');
		val.setAttribute('min', '1');
	    val.setAttribute('max', '20');
	    val.setAttribute('id', 'val');
	    val.setAttribute('value', '1');
	    
	    let button = document.createElement('button');
	    button.setAttribute('id', 'delete');
	    button.setAttribute('onclick', 'del()');
	    let buttontxt = document.createTextNode('삭제');
		
	    button.append(buttontxt);
	    vtd1.append(txt1);
	    vtd1.append(val);
	    vtd1.append(button);
	    
	    document.querySelector('.result').appendChild(vtd1);
	    if (document.getElementsByTagName("td").length > 21) {
	        document.querySelector(".bag").disabled = true;
	    }
		
	    if(event.target.value=="캐리어"){
	    	val.setAttribute('name', 'bag_val_1');
	    } else if(event.target.value=="백팩"){
	    	val.setAttribute('name', 'bag_val_2');
	    }
	});
	
