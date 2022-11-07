const half_r = 30;
const center = 310;
const axis_len = 75;
let circle_x;
let circle_y;
let get_X;
let get_Y;
const HALF_GRAPH_WIDTH = 310;
const R_IN_PIXELS = 30;

const graph = document.getElementById("var11357");

let inputXGraphic;
let inputYGraphic;
let inputRGraphic;

//document.getElementById("newPointForm:txt2").value = 1;

function change_scale() {
    const r = document.getElementsByClassName("r_value")[0].innerText;
    change_top_right(r);
    change_bottom_right(r);
    change_bottom_left(r);
    change_axis(r);
}

function remove_points() {
    let points = document.getElementsByClassName("point");
    for (let i = points.length - 1; i >= 0; i--) {
        points[i].remove();
    }
}

function draw_point(x, y, r, answer) {

    const rx = 10;
    const ry = 10;
    let color;
    if (answer === "true") {
        color = "green";
    }
    else {
        color = "red";
    }
    const cx = x * R_IN_PIXELS * 2 + HALF_GRAPH_WIDTH;
    const cy = HALF_GRAPH_WIDTH - y * R_IN_PIXELS * 2;

    const ellipse = "<ellipse " + "rx=\"" + rx + "\" ry=\"" + ry + "\" fill=\"" + color + "\" cx=\"" + cx + "\" cy=\"" + cy + "\" class='point' />";

    let g = document.getElementById("var11357");
    g.insertAdjacentHTML("beforeend", ellipse);


}

function change_top_right(r) {
    let pol = document.getElementById("top_right");
    pol.setAttribute("points", `${310 + half_r * r} 310, 310 ${310 - half_r * 2 * r}, 310 310`);
}

function change_points(r) {
    let points = document.getElementsByClassName("point");
    for (let point of points) {

    }
}

function change_bottom_right(r) {
    let rec = document.getElementById("bottom_right");
    let w_h = half_r * 2 * r;
    rec.setAttribute("width",  `${half_r * 2 * r}`);
    rec.setAttribute("height", `${half_r * 2 * r}`);
}

function change_bottom_left(r) {
    let circle = document.getElementById("bottom_left");
    circle.setAttribute("d", `M310,310 L${310 - half_r * r},310   A25,25 1 0,0    310,${310 + half_r * r}  z`)
}

function change_axis(r) {
    document.getElementById("x_arrow").setAttribute("points", `${310 + axis_len * r + 5} 310, ${310 + axis_len * r} 313, ${310 + axis_len * r} 307`);
    document.getElementById("y_arrow").setAttribute("points", `310 ${310 - axis_len * r - 5}, 307 ${310 - axis_len * r}, 313 ${310 - axis_len * r}`);

    document.getElementById("y_axis").setAttribute("y1", `${310-axis_len * r}`);
    document.getElementById("y_axis").setAttribute("y2", `${310+axis_len * r}`);
    document.getElementById("x_axis").setAttribute("x1", `${310-axis_len * r}`);
    document.getElementById("x_axis").setAttribute("x2", `${310+axis_len * r}`);

    document.getElementById("m_y1").setAttribute("y1",`${310-half_r * 2 * r }`);
    document.getElementById("m_y1").setAttribute("y2",`${310-half_r * 2 * r }`);

    document.getElementById("m_y2").setAttribute("y1",`${310-half_r * r }`);
    document.getElementById("m_y2").setAttribute("y2",`${310-half_r * r }`);

    document.getElementById("m_y3").setAttribute("y1",`${310+half_r * r }`);
    document.getElementById("m_y3").setAttribute("y2",`${310+half_r * r }`);

    document.getElementById("m_y4").setAttribute("y1",`${310+half_r * 2 * r }`);
    document.getElementById("m_y4").setAttribute("y2",`${310+half_r * 2 * r }`);

    document.getElementById("m_x1").setAttribute("x1",`${310+half_r * 2 * r }`);
    document.getElementById("m_x1").setAttribute("x2",`${310+half_r * 2 * r }`);

    document.getElementById("m_x2").setAttribute("x1",`${310+half_r * r }`);
    document.getElementById("m_x2").setAttribute("x2",`${310+half_r * r }`);

    document.getElementById("m_x3").setAttribute("x1",`${310-half_r * r }`);
    document.getElementById("m_x3").setAttribute("x2",`${310-half_r * r }`);

    document.getElementById("m_x4").setAttribute("x1",`${310-half_r * 2 * r }`);
    document.getElementById("m_x4").setAttribute("x2",`${310-half_r * 2 * r }`);

    document.getElementById("t_a_x").setAttribute("x", `${310 + axis_len * r}`);
    document.getElementById("t_a_y").setAttribute("y", `${310 - axis_len * r}`);

    document.getElementById("t_y1").setAttribute("y", `${310 - half_r * 2 * r + 5}`);
    document.getElementById("t_y2").setAttribute("y", `${310 - half_r * r + 5}`);
    document.getElementById("t_y3").setAttribute("y", `${310 + half_r * r + 5}`);
    document.getElementById("t_y4").setAttribute("y", `${310 + half_r * 2 * r + 5}`);

    document.getElementById("t_x1").setAttribute("x", `${310 + half_r * 2 * r - 5}`);
    document.getElementById("t_x2").setAttribute("x", `${310 + half_r * r - 5}`);
    document.getElementById("t_x3").setAttribute("x", `${310 - half_r * r - 5}`);
    document.getElementById("t_x4").setAttribute("x", `${310 - half_r * 2 * r - 5}`);
}

document.getElementById("var11357").addEventListener("mousedown", function (event) {


    inputXGraphic = document.getElementById("pointFromGraphic:hiddenXForGraphic");
    inputYGraphic = document.getElementById("pointFromGraphic:hiddenYForGraphic");
    inputRGraphic = document.getElementById("pointFromGraphic:hiddenRForGraphic");


    const r = document.getElementsByClassName("r_value")[0].innerText;


    circle_x = ((event.offsetX - HALF_GRAPH_WIDTH) / (R_IN_PIXELS * 2 * r)).toFixed(5) * r;
    circle_y = (-(event.offsetY - HALF_GRAPH_WIDTH) / (R_IN_PIXELS * 2 * r)).toFixed(5) * r;


    inputYGraphic.value = circle_y;
    inputXGraphic.value = circle_x;
    inputRGraphic.value = r;

    if (circle_x != null && circle_y != null) {

        jsf.ajax.request('pointFromGraphic:send', null, {
            'javax.faces.behavior.event': 'action',
            'execute': '@form',
            'render': 'remove_points pointsTable ugly_function'
        });
    }
});


