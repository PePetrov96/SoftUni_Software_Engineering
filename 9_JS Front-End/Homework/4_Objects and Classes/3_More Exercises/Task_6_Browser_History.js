function solve(object, commands) {
    function browse() {
        for (let command of commands) {
            let tokens = command.split(' ');
            let action = tokens.shift();
            let site = tokens.join(' ');

            switch (action) {
                case 'Open':
                    object["Open Tabs"].push(site);
                    object["Browser Logs"].push(command);
                    break;
                case 'Close':
                    let index = object["Open Tabs"].indexOf(site);

                    if (index !== -1) {
                        object["Open Tabs"] = object["Open Tabs"].filter(tab => tab.toLowerCase() !== site.toLowerCase());
                        object["Browser Logs"].push(command);
                        object["Recently Closed"].push(site);
                    }
                    break;
                case 'Clear':
                    object["Open Tabs"] = [];
                    object["Browser Logs"] = [];
                    object["Recently Closed"] = [];
                    break;
            }
        }
    }

    browse();
    function print() {
        console.log(object["Browser Name"]);
        console.log(`Open Tabs: ${object["Open Tabs"].join(', ')}`);
        console.log(`Recently Closed: ${object["Recently Closed"].join(', ')}`);
        console.log(`Browser Logs: ${object["Browser Logs"].join(', ')}`);
    }

    print();
}

solve({"Browser Name":"Google Chrome","Open Tabs":["Facebook","YouTube","Google Translate"],
    "Recently Closed":["Yahoo","Gmail"], "Browser Logs":["Open YouTube","Open Yahoo",
        "Open Google Translate","Close Yahoo","Open Gmail","Close Gmail","Open Facebook"]},
    ["Close Facebook", "Open StackOverFlow", "Open Google"]);
solve({"Browser Name":"Mozilla Firefox", "Open Tabs":["YouTube"],
    "Recently Closed":["Gmail", "Dropbox"],"Browser Logs":["Open Gmail", "Close Gmail", "Open Dropbox",
            "Open YouTube", "Close Dropbox"]},
    ["Open Wikipedia", "Clear History and Cache", "Open Twitter"]);