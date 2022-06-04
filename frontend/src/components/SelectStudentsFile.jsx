import React from "react";

function SelectStudentsFile({setStudents, setUnsortedStudents}) {

  const getStudents = (text) => {
    const lines = text.split("\r\n");
    return lines.map((line) => {
      const values = line.split(",");
      return { name: values[0], performance: values[1] };
    });
  };

  const handleChange = async (e) => {
    e.preventDefault();
    const reader = new FileReader();
    reader.onload = async (e) => {
      const text = e.target.result;
      const students = getStudents(text);
      setStudents(students);
      setUnsortedStudents(students);
    };
    reader.readAsText(e.target.files[0]);
  };

  return (
    <>
      <label
        htmlFor="file-selector"
        className="block text-sm font-medium text-gray-700"
      >
        Select students file
      </label>
      <input
        name="file-selector"
        className="mb-3 text-xs"
        type="file"
        onChange={handleChange}
      />
    </>
  );
}

export default SelectStudentsFile;
