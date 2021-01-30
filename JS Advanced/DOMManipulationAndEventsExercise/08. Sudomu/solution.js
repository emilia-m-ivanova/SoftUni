function solve() {
    let matrixOfElements = Array.from(document.querySelectorAll('tbody tr'));
    matrixOfElements = matrixOfElements.map(row=>{
        return Array.from(row.querySelectorAll('td input'));
    })
    const table = document.querySelector('table');
    const [checkBtn, clearBtn] = Array.from(document.querySelectorAll('button'));
    const output = document.querySelector('#check p');

    checkBtn.addEventListener('click',checkResult);
    clearBtn.addEventListener('click',clearTable);

    function clearTable(){
        matrixOfElements.forEach(row=>{
            row.forEach(el=>{
                el.value = '';
            })
        });
        output.textContent = '';
        table.style.border = '';
    }

    function checkResult(){
        let matrix = matrixOfElements.map(row=>{
            return row.map(el=>{
                return el.value;
            })
        });

        if(isCorrect(matrix)){
            table.style.border = '2px solid green';
            output.textContent = 'You solve it! Congratulations!'
            output.style.color = 'green';
        }else{
            table.style.border = '2px solid red';
            output.textContent = 'NOP! You are not done yet...';
            output.style.color = 'red';
        }
    }

    function isCorrect(matrix){
        let areDifferent = true;
        matrix.forEach(row=>{
            row.forEach((el,i)=>{
                row.forEach((el2,i2)=>{
                    if(i!==i2){
                        if(el===el2){
                            areDifferent = false;
                        }
                    }
                })
            })
        });
        for (let col = 0; col < matrix[0].length; col++) {
            for (let row = 0; row < matrix.length; row++) {
                for (let row2 = 0; row2 < matrix.length; row2++) {
                    if(row!==row2){
                        if(matrix[row][col]===matrix[row2][col]){
                            areDifferent = false;
                        }
                    }
                }
            }
        }
        return areDifferent;
    }
}