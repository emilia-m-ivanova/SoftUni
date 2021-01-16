function solve(commands) {
    let arr = [];
    let i = 1;
    commands.forEach(command => {
        if (command === 'add') {
            arr.push(i);
        } else {
            arr.pop();
        }
        i++;
    })
    return arr.length>0 ? arr.join('\n') : 'Empty';
}