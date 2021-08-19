const selectElement = document.querySelector('.bag');
var test;
selectElement.addEventListener('change', (event) => {
    let vli1 = document.createElement('li');
    vli1.setAttribute('id', 'bagg');
    let txt1 = document.createTextNode(event.target.value);
    console.log(txt1);

    
    let val = document.createElement('input');
    val.setAttribute('type', 'number');
    val.setAttribute('min', '1');
    val.setAttribute('max', '20');
    val.setAttribute('id', 'val');
    val.setAttribute('value', '1');
 
    //삭제버튼
    let button = document.createElement('button');
    button.setAttribute('id', 'delete');
    button.setAttribute('onclick', 'del()');
    let buttontxt = document.createTextNode('삭제');

    button.append(buttontxt);
    vli1.append(txt1);
    vli1.append(val);
    vli1.append(button);

    document.querySelector('.result').appendChild(vli1);
    if (document.getElementsByTagName("li").length > 9) {
        document.querySelector(".bag").disabled = true;
    }
    
    if(event.target.value=="캐리어"){
    	val.setAttribute('name', 'bag_val_1');
    } else if(event.target.value=="백팩"){
    	val.setAttribute('name', 'bag_val_2');
    }
});

function del() {
    var del_val = document.getElementById("bagg");
    del_val.remove();
    document.querySelector(".bag").disabled = false;
}