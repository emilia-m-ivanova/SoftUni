function solve(){
  document.querySelector('.create').addEventListener('click',addPost);
  const author = document.getElementById('creator');
  const title = document.getElementById('title');
  const category = document.getElementById('category');
  const content = document.getElementById('content');
  const section = document.querySelector('.site-content section');
  const archiveSection = document.querySelector('.archive-section ol');

  function addPost(ev) {
    ev.preventDefault();
    const element = createElement('article',{},
        createElement('h1',{},title.value),
        createElement('p',{},'Category:',
            createElement('strong',{},category.value)),
        createElement('p',{},'Creator:',
            createElement('strong',{},author.value)),
        createElement('p',{},content.value),
        );
    const btnDelete = createElement('button',{className: 'btn delete'},'Delete');
    const btnArchive = createElement('button',{className:'btn archive'},'Archive');
    btnDelete.addEventListener('click',remove);
    const text = title.value
    btnArchive.addEventListener('click',archive);
    element.appendChild(createElement('div',{className:'buttons'},
        btnDelete,btnArchive))
    section.appendChild(element);
  }

  function remove(ev){
    const element = ev.target.parentNode.parentNode;
    element.remove();
  }

  function archive(ev){
    const element = ev.target.parentNode.parentNode;
    const text = element.querySelector('h1').textContent;
    archiveSection.appendChild(createElement('li',{},text));
    Array.from(archiveSection.querySelectorAll('li'))
        .sort((a,b)=>a.textContent.localeCompare(b.textContent))
        .forEach(e=>archiveSection.appendChild(e));
    element.remove();
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

}
