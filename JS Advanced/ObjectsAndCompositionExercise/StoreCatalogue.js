function createCatalogue(arr) {
    let sorted = arr.sort().map(e => {
        e = e.replace(' :', ':');
        return '  ' + e;
    });
    sorted.unshift(sorted[0].charAt(2));
    let i = 2;
    while (i<sorted.length) {
        if (sorted[i].charAt(2) !== sorted[i - 1].charAt(2)) {
            sorted.splice(i, 0, sorted[i].charAt(2));
            i++;
        }
        i++;
    }
    return sorted.join('\n');
}
