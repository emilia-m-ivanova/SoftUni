function modifyWorker(worker) {
    if(worker.dizziness){
        const water = 0.1 * worker.weight * worker.experience;
        worker.levelOfHydrated += water;
        worker.dizziness = false;
    }
    return worker;
}

console.log(modifyWorker({ weight: 95,
        experience: 3,
        levelOfHydrated: 0,
        dizziness: false
    }
));