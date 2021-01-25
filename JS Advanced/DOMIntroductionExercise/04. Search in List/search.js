function search() {
   const towns = Array.from(document.querySelectorAll('#towns li'));
   const input = document.querySelector('#searchText').value;
   let result = 0;
   towns.forEach(e=>{
       if(e.textContent.includes(input)){
           e.style.textDecoration = 'underline';
           e.style.fontWeight = 'bold'
           result++;
       }else{
           e.style.textDecoration = '';
           e.style.fontWeight = ''
       }
   });
   document.querySelector('#result').textContent = result + ' matches found';
}
