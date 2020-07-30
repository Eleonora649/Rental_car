function sendForm(idUtente, actionName){
     document.myForm.idUtente.value = idUtente;
     document.myForm.action = actionName;
	 document.myForm.submit();
}