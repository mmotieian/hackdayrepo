"use strict";
var MOUSE_TIME_OUT = 400;
var lastMousePos = [-1, -1];
var hiliteMargin = 10;
var coorW = 1260;
var coorH = 477;
var mapGraph;
var locationArray;
var locationMap;
var context;


function getMousePos(e, offset) {
    var tempArray = [e.pageX - offset.left, e.pageY - offset.top];
    return tempArray;
}

function setHoverEvent() {
    $("#map").mousemove(function(e) {
        var mouseMove = new Date().getTime();
        var offset = $(this).offset();
        lastMousePos = getMousePos(e, offset);
        setTimeout(function() {
            var tempPos = getMousePos(e, offset);
            if(lastMousePos[0] === tempPos[0] && lastMousePos[1] === tempPos[1]) {
                getLocation(tempPos, e);
            } else {
                lastMousePos = getMousePos(e);    
            }
        }, MOUSE_TIME_OUT);
    });
}

function getLocation(pos) {
    var mapW = $("#map").width();
    var mapH = $("#map").height();
//    pos[0] = pos[0] / mapW;
//    pos[1] = pos[1] / mapH;
    var i;
    for(i = 0; i < locationArray.length; i += 1) {
        var topLeft = locationArray[i].tLVert;
        var bottomRight = locationArray[i].bRVert;
        var width = (bottomRight[0] - topLeft[0]) * mapW + hiliteMargin;
        var height = (bottomRight[1] - topLeft[1]) * mapH + hiliteMargin;
        if(pos[0] >= topLeft[0]*mapW && pos[0] <= bottomRight[0]*mapW &&
            pos[1] >= topLeft[1]*mapH && pos[1] <= bottomRight[1]*mapH) {
        	
            return;
        }
    }
}

function highlight(emp) {
	var mapW = $("#map").width();
    var mapH = $("#map").height();
	context.fillRect(topLeft[0] * mapW - hiliteMargin/2, topLeft[1] * mapH - hiliteMargin/2,
            width, height);
	context.clearRect(0, 0, $("#path").width(), $("#path").height());
    context.fillRect(topLeft[0] * mapW - hiliteMargin/2, topLeft[1] * mapH - hiliteMargin/2,
                     width, height);
    popUp("Name", "Title", "Phone", "Cube", "Alias", "Boss");
}

function graphNode(loc, tL, bR, neigh) {
    return {
        location: loc,
        tLVert: [tL[0]/1260, tL[1]/477],
        bRVert: [bR[0]/1260, bR[1]/477],
        neighbors: neigh
    };
}

function buildMapGraph() {
	debugger
    var bernardo = graphNode("1-9109", [320, 81], [336, 97], []);
    var james = graphNode("1-9116", [346, 62], [362, 78], []);
    var hall1 = graphNode("hall1", [335, 36], [350, 151], [bernardo, james]);
    var westHall = graphNode("westHall", [113, 151], [1150, 173], [hall1]);
    var lobby = graphNode("lobby", [780, 174], [820, 300], [westHall]);
    locationArray = [bernardo, james];
    locationMap = {};
    location[bernardo.location] = bernardo;
    location[james.location] = james;
    return lobby;
}

function popUp(name, title, phone, location, alias, supervisor) {
	var popup = $('<div id="popup"></div>');
	popup.append("<h4>" + name + " (" + alias + ")</h4>");
	popup.append("<h4>" + title + "</h4>");
	popup.append("<h4>Phone number: " + phone + "</h4>");
	popup.append("<h4>Location: " + location + "</h4>");
	popup.append("<h4>Supervisor: " + supervisor + "</h4>");
    popup.dialog({modal: true});
}

function setUpCanvas() {
    var ctx = document.getElementById("path").getContext("2d");
    var path = document.getElementById("path");
    path.setAttribute("height", parseInt($("#map").height()));
    path.setAttribute("width", $("#map").width());
    $("#path").css("position", "absolute");
    $("#path").css("top", $("#map").offset().top);
    ctx.fillStyle = "rgb(1, 215, 245)";
    return ctx;
}

function selectLocation(location) {
	
}

$(document).ready(function() {
    mapGraph = buildMapGraph();
    context = setUpCanvas();
    selectLocation($("#cubicle").text());
    setHoverEvent();
});