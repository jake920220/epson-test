import React, {useState, useEffect} from 'react';
import {
  View,
  StyleSheet,
  Text,
  TouchableOpacity,
  NativeModules,
  Button,
} from 'react-native';
const {CalendarModule} = NativeModules;
// import RnEpsonReceiptPrinter from 'react-native-rn-epson-receipt-printer';

const App = () => {
  useEffect(() => {
    console.log('hello', NativeModules);
  }, []);
  const [text, setText] = useState('');
  const [num, setNum] = useState(0);

  const init = () => {
    CalendarModule.initializePrinter((isSuccess) => {
      console.log(isSuccess);
    });
  };

  return (
    <View style={styles.container}>
      <Button title={'Initialize Printer'} color="#841584" onPress={init} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#ffffff',
  },
  title: {
    fontSize: 30,
  },
});

export default App;
