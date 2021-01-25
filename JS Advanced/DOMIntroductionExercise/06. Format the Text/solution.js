function solve() {
    const text = document.getElementById('input').value;
    const regExp = /.+?[.?!] */g;
    let match = regExp.exec(text);
    let paragraphs = [];
    while (match!==null){
        paragraphs.push(match);
        match = regExp.exec(text);
    }
    paragraphs = paragraphs.reduce((acc,el,index)=>{
        if(index%3===0){
            acc.push(`<p>${el}`);
        }else if(index%3===2){
            acc[acc.length-1] +=`${el}</p>`;
        }else{
            acc[acc.length-1] +=el;
        }
        return acc;
    },[])
    const result = document.getElementById('output');
    paragraphs.forEach(e => {
        result.innerHTML += e;
    })
}