window.addEventListener('load', function() {
    let valueField1 = document.querySelector("input#number1");
    let valueField2 = document.querySelector("input#number2");
    let plusButton = document.querySelector("input#plus");
    plusButton.addEventListener('click', function() {
        let summ = Number.parseInt(valueField1.value) + Number.parseInt(valueField2.value);
        let result = document.createTextNode(summ);
        let resultBlock = document.querySelector("div#main-block");
        let textBlock = document.createElement("p");
        textBlock.appendChild(result);
        resultBlock.appendChild(textBlock);
    });
});
