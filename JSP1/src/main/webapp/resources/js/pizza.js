console.log("pizza.js 파일이 요청됨");

const plusBtn = document.querySelector(".plus");
const minusBtn = document.querySelector(".minus");

plusBtn.addEventListener("click", () => {
    let amount = document.querySelector("input[name='amount']").value;
    amount++;
    document.querySelector("input[name='amount']").value = amount;
});

minusBtn.addEventListener("click", () => {
    let amount = document.querySelector("input[name='amount']").value;
    amount--;
    document.querySelector("input[name='amount']").value = amount;
});