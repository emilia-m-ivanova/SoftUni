function generateReport() {
    const checkBoxes = Array.from(document.querySelectorAll('thead th input'));
    let rows = Array.from(document.querySelectorAll('tbody tr'));
    const properties = [];
    checkBoxes.forEach((box,index)=>{
        if(box.checked){
            properties.push([box.name, index]);
        }
    });
    rows = rows.map(row=>{
        const objectRow = {};
        properties.forEach(property=>{
            objectRow[property[0]] = row.children[property[1]].textContent;
        })
        return objectRow;
    })
    document.getElementById('output').textContent = JSON.stringify(rows);
}