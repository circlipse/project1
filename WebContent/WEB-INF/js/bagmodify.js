
	document.querySelector(".bag").disabled = true;

	function del() {
	    var del_val = document.getElementById("bagg");
	    del_val.remove();
	    document.querySelector(".bag").disabled = false;
	}