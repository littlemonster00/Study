import Header from "./Header";

const layoutStyle = {
  margin: 20,
  padding: 20,
  border: "1px soild #DDD"
};

const Layout = props => {
  console.log(props);
  return (
    <div style={layoutStyle}>
      <Header />
      {props.children}
    </div>
  );
};
export default Layout;