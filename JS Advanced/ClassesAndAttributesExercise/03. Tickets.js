function sortTickets(tickets, criteria){
    class Ticket {
        constructor(destination,price,status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    tickets = tickets.map(e=>{
        let data = e.split('\|');
        return new Ticket(data[0],Number(data[1]),data[2]);
    });

    return tickets.sort((f,s)=>{
        if(criteria==='price'){
            return f.price - s.price;
        }
        return f[criteria].localeCompare(s[criteria]);
    });
}