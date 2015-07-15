"use strict";
var MOUSE_TIME_OUT = 400;
var lastMousePos = [-1, -1];
var hiliteMargin = 10;
var mapGraph;
var locationArray;
var context;


function getMousePos(e, offset) {
    var tempArray = [e.pageX - offset.left, e.pageY - offset.top];
    return tempArray;
}

function setHoverEvent() {
    $("#path").mousemove(function(e) {
        var mouseMove = new Date().getTime();
        var offset = $(this).offset();
        lastMousePos = getMousePos(e, offset);
        setTimeout(function() {
            var tempPos = getMousePos(e, offset);
            if(lastMousePos[0] === tempPos[0] && lastMousePos[1] === tempPos[1]) {
                getLocation(tempPos);
            } else {
                lastMousePos = getMousePos(e);    
            }
        }, MOUSE_TIME_OUT);
    });
}

function getLocation(pos) {
    debugger
    var mapW = $("#map").width();
    var mapH = $("#map").height();
    pos[0] = pos[0] / mapW;
    pos[1] = pos[1] / mapH;
    var i;
    for(i = 0; i < locationArray.length; i += 1) {
        context.clearRect(0, 0, $("#path").width(), $("#path").height());
        var topLeft = locationArray[i].tLVert;
        var bottomRight = locationArray[i].bRVert;
        var width = (bottomRight[0] - topLeft[0]) * mapW + hiliteMargin;
        var height = (bottomRight[1] - topLeft[1]) * mapH + hiliteMargin;
        if(pos[0] >= topLeft[0] && pos[0] <= bottomRight[0] &&
            pos[1] >= topLeft[1] && pos[1] <= bottomRight[1]) {
            context.fillRect(topLeft[0] * mapW - hiliteMargin/2, topLeft[1] * mapH - hiliteMargin/2,
                             width, height);
            popUp();
            return;
        }
    }
    $("#a").text("");
}

function popUp() {

}

function graphNode(name, tL, bR, neigh) {
    return {
        id: name,
        tLVert: [tL[0]/1260, tL[1]/477],
        bRVert: [bR[0]/1260, bR[1]/477],
        neighbors: neigh
    };
}

function buildMapGraph() {
    var bernardo = graphNode("1-9109", [320, 81], [336, 97], []);
    var james = graphNode("1-9116", [346, 62], [362, 78], []);
    var hall1 = graphNode("hall1", [335, 36], [350, 151], [bernardo, james]);
    var westHall = graphNode("westHall", [113, 151], [1150, 173], [hall1]);
    var lobby = graphNode("lobby", [780, 174], [820, 300], [westHall]);
    locationArray = [lobby, westHall, hall1, bernardo, james];
    return lobby;
}

function displayInfo() {
    
}

function setUpCanvas() {
    var ctx = document.getElementById("path").getContext("2d");
    var path = document.getElementById("path");
    path.setAttribute("height", parseInt($("#map").height()));
    path.setAttribute("width", $("#map").width());
    $("#path").css("position", "absolute");
    $("#path").css("top", $("#map").offset().top);
    ctx.fillStyle = "red";
    return ctx;
}

$(document).ready(function() {
    mapGraph = buildMapGraph();
    context = setUpCanvas();
    setHoverEvent();
});