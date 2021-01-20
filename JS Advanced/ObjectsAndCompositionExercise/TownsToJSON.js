function createJSONTable(arr){
    arr.shift();
    const result = [];
    arr.forEach(e=>{
        e = e.split(/\s*\|\s*/).filter(e=>e!=='');
        let [Town, Latitude, Longitude] = e;
        Latitude = Number(Number(Latitude).toFixed(2));
        Longitude = Number(Number(Longitude).toFixed(2));
        result.push({
            Town,
            Latitude,
            Longitude,
        })
    })
    return JSON.stringify(result);
}
