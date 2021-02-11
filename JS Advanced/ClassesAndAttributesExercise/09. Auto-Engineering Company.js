function solve(arr) {
    const brands = new Map;
    arr.map(e => e.split(/ \| /))
        .forEach(e => {
            const [name, model, produced] = e;
            if(!brands.has(name)){
                brands.set(name,new Map);
            }
            if(!brands.get(name).has(model)){
                brands.get(name).set(model,0);
            }
            brands.get(name).set(model,brands.get(name).get(model) + Number(produced));
        });
    return Array.from(brands.entries()).map(e=>{
        return e[0] + '\n' + Array.from(e[1].entries())
            .map(m=>'###' + m[0] + ' -> ' + m[1])
            .join('\n');
    }).join('\n');
}