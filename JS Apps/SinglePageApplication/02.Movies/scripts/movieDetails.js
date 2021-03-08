export {showDetails, setUpDetails}

let detailsSection;
let sections;
let deleteBtn;
let editBtn;
let likeBtn;
let numberOfLikes;

function setUpDetails(detailsParam, sectionsParam, deleteParam, editParam, likeParam) {
    detailsSection = detailsParam;
    sections = sectionsParam;
    deleteBtn = deleteParam;
    editBtn = editParam;
    likeBtn = likeParam;
}

async function showDetails(id) {
    sections.forEach(s => s.style.display = 'none');
    detailsSection.style.display = '';
    const [responseDetails,responseLikes] = await Promise.all([
        fetch('http://localhost:3030/data/movies/' + id),
        fetch('http://localhost:3030/data/likes/' + id),
    ])
    // const response = await fetch('http://localhost:3030/data/movies/' + id);
    const data = await responseDetails.json();
    if (!responseDetails.ok) {
        return data.message;
    }
    if(responseLikes.ok){
        const likes = await responseDetails.json();
    }else{
        numberOfLikes = 0;
    }
    detailsSection.querySelector('h1').textContent = 'Movie title: ' + data.title;
    detailsSection.querySelector('img').src = data.img;
    detailsSection.querySelector('p').textContent = data.description;
    detailsSection.querySelector('.enrolled-span').textContent = 'Liked ' + numberOfLikes;

    if(data._ownerId===sessionStorage.id){
        deleteBtn.style.display = '';
        editBtn.style.display = '';
        likeBtn.style.display = 'none';
    }else{
        deleteBtn.style.display = 'none';
        editBtn.style.display = 'none';
        likeBtn.style.display = '';
    }
    likeBtn.parentNode.id = id;
}