function createRegister(arr) {
    const result = arr.map(e => {
        let [name, level, items] = e.split(' / ');
        level = Number(level);
        items = items ? items.split(', ') : []
        return {
            name,
            level,
            items,
        }
    });
    return JSON.stringify(result);
}
