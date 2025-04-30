export default function Sidebar() {
    return (
        <div className="w-60 bg-gradient-to-b from-yellow-300 to-teal-600 text-black p-5 shadow-md">
            <h2 className="text-xl font-bold mb-10">Menu</h2>
            <ul className="space-y-4">
                <li className="hover:font-semibold cursor-pointer">Dashboard</li>
                <li className="font-bold text-black">Search Scores</li>
                <li className="hover:font-semibold cursor-pointer">Reports</li>
                <li className="hover:font-semibold cursor-pointer">Settings</li>
            </ul>
        </div>
    );
}