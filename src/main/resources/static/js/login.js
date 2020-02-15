function getLoginForm(x){
    x_counter = null;
    if (x == "signIn"){
        x_counter = "signUp";
    }else{
        x_counter = "signIn";
    }
    form_object = document.getElementById(x);
    counter_form_object = document.getElementById(x_counter);
    form_object.classList.add("active");
    counter_form_object.classList.remove("active");
}
