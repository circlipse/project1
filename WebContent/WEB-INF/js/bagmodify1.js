
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
		if((event.target.value).valueof==('캐리어').valueof){
			vtd1.setAttribute('id', 'bagg1');
			console.log('a');
		} else{
			vtd1.setAttribute('id', 'bagg2');
			console.log('b');
		}
		console.log(event.target.value);
		console.log(typeof(event.target.value));
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
	    if((event.target.value).valueof==('캐리어').valueof){
	    button.setAttribute('onclick', 'del1()');
	    } else{
	    button.setAttribute('onclick', 'del2()');
	    } 
	    let buttontxt = document.createTextNode('삭제');
		
	    button.append(buttontxt);
	    vtd1.append(txt1);
	    vtd1.append(val);
	    vtd1.append(button);
	    
	    if((event.target.value).valueof==('캐리어').valueof){
	    document.querySelector('.result1').appendChild(vtd1);
	    } else{
	    document.querySelector('.result2').appendChild(vtd1);
	    }
	    
	    if (document.getElementsByTagName("td").length > 19) {
	        document.querySelector(".bag").disabled = true;
	    }
		
	    if((event.target.value).valueof==("캐리어").valueof){
	    	val.setAttribute('name', 'bag_val_1');
	    } else{
	    	val.setAttribute('name', 'bag_val_2');
	    }
		
	});