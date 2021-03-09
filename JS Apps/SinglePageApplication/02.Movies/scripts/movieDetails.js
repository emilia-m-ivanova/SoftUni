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
        fetch('http://localhost:3030/data/likes'),
    ])
    const data = await responseDetails.json();
    if (!responseDetails.ok) {
        return alert(data.message);
    }
    const likes = await responseLikes.json();
    if(responseLikes.ok){
        numberOfLikes = likes.filter(e=>e.movieId===id).length;
    }else{
       alert(likes.message);
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
    if(likes.some(e=>e._ownerId===sessionStorage.id&&e.movieId===id)||!sessionStorage.id){
        likeBtn.style.display = 'none';
    }
}