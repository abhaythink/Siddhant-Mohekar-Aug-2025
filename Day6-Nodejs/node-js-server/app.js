const http = require('http')

const route = require('./route')

const server = http.createServer(route)

server.listen(5000);

// const server2 = http.createServer((requ,respo)=>{
//     console.log("we got request");
//     console.log(requ.url,requ.method,requ.headers);
//     respo.setHeader('Content-Type','text/html');
//     respo.write("<html>")
//     respo.write("<head><title>The Book 2</title></head>")
//     respo.write("<body><h2>Here is name of book 2</h2></body>")
//     respo.write("</html>")
//     respo.end();
//     // process.exit();
// })

// server2.listen(5000);



