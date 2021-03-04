async function loadStudents(){
    const tableBody = document.querySelector('tbody');
    tableBody.innerHTML = '';
    const url = 'http://localhost:3030/jsonstore/collections/students';
    const data = await createRequest(url);
    Object.values(data)
        .map(e=>{
            return createElement('tr',{},
                createElement('td',{},e._id),
                createElement('td',{},e.firstName),
                createElement('td',{},e.lastName),
                createElement('td',{},e.facultyNumber),
                createElement('td',{},e.grade));
        })
        .forEach(e=>tableBody.appendChild(e));
    document.querySelector('form').addEventListener('submit',addStudent);
}

async function addStudent(ev){
    ev.preventDefault();
    const url = 'http://localhost:3030/jsonstore/collections/students';
    const studentData = [...new FormData(ev.target).entries()];
    const body = JSON.stringify(studentData.reduce((acc,current)=>{
        acc[current[0]] = current[1];
        return acc;
    },{}));
     await createRequest(url,{
         method:'post',
         headers:{
             'Content-Type':'application/json'
         },
         body,
     });
     ev.target.reset();
     loadStudents();
}

async function createRequest(url,options){
    const response = await fetch(url,options);
    const parsed = await response.json();
    if(!response.ok){
        return alert(parsed.message);
    }
    return parsed;
}

function createElement(tagName,attributes,...content) {
    const element = document.createElement(tagName);

    //add attribute or event listener
    for (let attr in attributes) {
        if (attr.substring(0,2) === 'on') {
            element.addEventListener(attr.substring(2).toLowerCase(), attributes[attr]);
        } else {
            element[attr] = attributes[attr];
        }
    }

    //add content or append a child element
    content.forEach(c => {
        if (typeof c === "string"|| typeof c === 'number') {
            element.textContent = c;
        } else {
            element.appendChild(c)
        }
    });
    return element;
}
loadStudents()