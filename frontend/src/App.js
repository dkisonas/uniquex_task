import StudentSorter from "./components/StudentSorter";
import "./index.css";

function App() {
  return (
    <div className="bg-white overflow-hidden shadow rounded-lg max-w-lg mx-auto">
      <div className="px-4 py-5 sm:p-6">
        <StudentSorter />
      </div>
    </div>
  );
}

export default App;
