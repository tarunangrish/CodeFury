function addElement()
{
const newDiv = document.createElement("div");

const newContent = document.createTextNode("beaut");

newDiv.appendChild(newContent);

const currentDiv = document.getElementById("productDetails");
document.body.insertBefore(newDiv, currentDiv); 

}