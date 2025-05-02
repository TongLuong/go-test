export default function Sidebar({
    currTab, setCurrTab
}) {
    const handleClick = e => {
        e = e || window.event;
        const target = e.target || e.srcElement;
        setCurrTab(target.value);


    };

    const getClass = (index) => {
        if (index === currTab) {
            return "font-bold text-black";
        }
        return "hover:font-semibold cursor-pointer";
    };

    return (
        <div className="w-60 bg-gradient-to-b from-yellow-300 to-teal-600 text-black p-5 shadow-md">
            <h2 className="text-xl font-bold mb-10">Menu</h2>
            <ul className="space-y-4" onClick={handleClick}>
                <li className={getClass(0)} value="0">Dashboard</li>
                <li className={getClass(1)} value="1">Search Scores</li>
                <li className={getClass(2)} value="2">Reports</li>
                <li className={getClass(3)} value="3">Settings</li>
            </ul>
        </div>
    );
}