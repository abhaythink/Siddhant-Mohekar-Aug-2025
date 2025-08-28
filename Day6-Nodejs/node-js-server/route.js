const fs = require('fs');

const requestHandler = (requ,respo) => {
    const url = requ.url;
    const meth = requ.method;
    if(url === '/'){
        respo.write("<html>")
        respo.write("<head><title>Register New Book</title></head>")
        respo.write("<body><h2>Register New Book</h2><br>")
        respo.write("<form action='/register' method='POST'><input type='text' name='bookname'><button type='submit'>submit</button></form>")
        respo.write("</body>")
        respo.write("</html>")
        return respo.end();        
    }
    if(url === '/register' && meth === 'POST'){
        const bn = [];
        requ.on('data',(chunk)=>{
            console.log(chunk);
            bn.push(chunk)
        });
        return requ.on('end',()=>{
            const fn = Buffer.concat(bn).toString();
            const bfn = fn.split("=")[1];
            fs.writeFile('booklist.txt',bfn,err => {
                respo.statusCode = 302;
                respo.setHeader('Location','/');
                return respo.end();
            });
        });
    }
    respo.setHeader('Content-Type','text/html');
    respo.write("<html>")
    respo.write("<head><title>The Book</title></head>")
    respo.write("<body><h2>Here is name of books</h2></body>")
    respo.write("</html>")
    respo.end();
}

module.exports = requestHandler;
