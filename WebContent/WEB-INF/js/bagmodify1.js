
	document.querySelector(".bag").disabled = true;
	
	function del1() {
	    var del_val = document.getElementById('bagg1');
	    del_val.remove(document.getElementsByTagName("tr"));
	    document.querySelector(".bag").disabled = false;
	}
	
	function del2() {
	    var del_val = document.getElementById('bagg2');
	    del_val.remove(document.getElementsByTagName("tr"));
	    document.querySelector(".bag").disabled = false;
	}
	
	
	const selectElement = document.querySelector('.bag');
	selectElement.addEventListener('change', (event) =>{
		

		
			
		let vtd1 = document.createElement('td');
		if(event.target.value=='캐리어'){
			vtd1.setAttribute('id', 'bagg1');
		} else if(event.target.value=='백팩'){
			vtd1.setAttribute('id', 'bagg2');
		}
		
		let txt1 = document.createTextNode(event.target.value);
		
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
	    } else if(event.target.value=='백팩'){
	    button.setAttribute('onclick', 'del2()');
	    } 
	    let buttontxt = document.createTextNode('삭제');
		
	    button.append(buttontxt);
	    vtd1.append(txt1);
	    vtd1.append(val);
	    vtd1.append(button);
	    
	    document.querySelector('.result').appendChild(vtd1);
	    if (document.getElementsByTagName("td").length > 19) {
	        document.querySelector(".bag").disabled = true;
	    }
		
	    if(event.target.value=="캐리어"){
	    	val.setAttribute('name', 'bag_val_1');
	    } else if(event.target.value=="백팩"){
	    	val.setAttribute('name', 'bag_val_2');
	    }
		
	});