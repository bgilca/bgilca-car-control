package com.example.bgilca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

@SuppressLint("ClickableViewAccessibility")
public class Ventscreen extends Headlight {
	static Button scaunstg;
	static Button scaundr;
	Button navi;
	Button headlight;
	Button home;
	Button fan, fanplus, fanminus, templus, teminus;
	// Button fan1 , fan2 , fan3 , fan4 ;
	Button cap, corp, craci;
	int fanspeed, tempsetup;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_ventscreen);

		ImageView image = (ImageView) findViewById(R.id.fanspeed);
		image.setImageResource(R.drawable.off);
		if (Storage.getFanspeed() == 0) {
			fanspeed = 0;
		} else {
			if (Storage.getFanspeed() == 1) {
				fanspeed = 1;
			} else {
				if (Storage.getFanspeed() == 2) {
					fanspeed = 2;
				} else {
					if (Storage.getFanspeed() == 3) {
						fanspeed = 3;
					}

					else {
						if (Storage.getFanspeed() == 4) {
							fanspeed = 4;
						}
					}
				}

			}
		}
		if (fanspeed == 0) {
			MyService.mConnectedThread.write("d");
			ImageView image1 = (ImageView) findViewById(R.id.fanspeed);
			image1.setImageResource(R.drawable.off);

		} else {
			if (fanspeed == 1) {
				MyService.mConnectedThread.write("e");
				ImageView image1 = (ImageView) findViewById(R.id.fanspeed);
				image1.setImageResource(R.drawable.fan1);

			} else {
				if (fanspeed == 2) {
					MyService.mConnectedThread.write("f");

					ImageView image1 = (ImageView) findViewById(R.id.fanspeed);
					image1.setImageResource(R.drawable.fan2);

				} else {
					if (fanspeed == 3) {
						MyService.mConnectedThread.write("g");
						ImageView image1 = (ImageView) findViewById(R.id.fanspeed);
						image1.setImageResource(R.drawable.fan3);

					} else {
						if (fanspeed == 4) {
							MyService.mConnectedThread.write("h");
							ImageView image1 = (ImageView) findViewById(R.id.fanspeed);
							image1.setImageResource(R.drawable.fan4);

						}
					}
				}
			}

		}
		tempsetup = Storage.tempsetup;
		if (tempsetup == 0) {
			MyService.mConnectedThread.write("d");
			ImageView image1 = (ImageView) findViewById(R.id.degwan);
			image1.setImageResource(R.drawable.low);

		} else {
			if (tempsetup == 1) {
				MyService.mConnectedThread.write("e");
				ImageView image1 = (ImageView) findViewById(R.id.degwan);
				image1.setImageResource(R.drawable.temp17);
			}

			else {
				if (tempsetup == 2) {
					MyService.mConnectedThread.write("f");

					ImageView image1 = (ImageView) findViewById(R.id.degwan);
					image1.setImageResource(R.drawable.temp18);
				}

				else {
					if (tempsetup == 3) {
						MyService.mConnectedThread.write("g");
						ImageView image1 = (ImageView) findViewById(R.id.degwan);
						image1.setImageResource(R.drawable.temp19);
					}

					else {
						if (tempsetup == 4) {
							MyService.mConnectedThread.write("h");
							ImageView image1 = (ImageView) findViewById(R.id.degwan);
							image1.setImageResource(R.drawable.temp20);
						}

						else {
							if (tempsetup == 5) {
								MyService.mConnectedThread.write("h");
								ImageView image1 = (ImageView) findViewById(R.id.degwan);
								image1.setImageResource(R.drawable.temp21);
							}

							else {

								if (tempsetup == 6) {
									MyService.mConnectedThread.write("h");
									ImageView image1 = (ImageView) findViewById(R.id.degwan);
									image1.setImageResource(R.drawable.temp22);
								}

								else {

									if (tempsetup == 7) {
										MyService.mConnectedThread.write("h");
										ImageView image1 = (ImageView) findViewById(R.id.degwan);
										image1.setImageResource(R.drawable.temp23);
									}

									else {

										if (tempsetup == 8) {
											MyService.mConnectedThread
													.write("h");
											ImageView image1 = (ImageView) findViewById(R.id.degwan);
											image1.setImageResource(R.drawable.temp24);
										}

										else {

											if (tempsetup == 9) {
												MyService.mConnectedThread
														.write("h");
												ImageView image1 = (ImageView) findViewById(R.id.degwan);
												image1.setImageResource(R.drawable.temp25);
											}

											else {

												if (tempsetup == 10) {
													MyService.mConnectedThread
															.write("h");
													ImageView image1 = (ImageView) findViewById(R.id.degwan);
													image1.setImageResource(R.drawable.temp26);
												}

												else {

													if (tempsetup == 11) {
														MyService.mConnectedThread
																.write("h");
														ImageView image1 = (ImageView) findViewById(R.id.degwan);
														image1.setImageResource(R.drawable.high);
													}

												}

											}

										}

									}

								}

							}

						}

					}
				}
			}

		}

		cap = (Button) findViewById(R.id.cap);
		if (Storage.getCap() == true) {
			cap.setPressed(true);
		}
		cap.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();

				cap.setPressed(!cap.isPressed());
				if (cap.isPressed()) {
					craci.setPressed(false);
					corp.setPressed(false);
				}
				// if(cap.isPressed())
				// {fan1.setPressed(true);}
				if (cap.isPressed()) {
					Storage.setCap(true);
					MyService.mConnectedThread.write("i");

				} else {
					Storage.setCap(false);
				}
				return true;
			}
		});

		corp = (Button) findViewById(R.id.corp);
		if (Storage.getCorp() == true) {
			corp.setPressed(true);
		}
		corp.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();
				corp.setPressed(!corp.isPressed());
				// if(corp.isPressed())
				// {fan1.setPressed(true);}
				if (corp.isPressed()) {
					Storage.setCorp(true);
					if (craci.isPressed()) {
						MyService.mConnectedThread.write("l");
						cap.setPressed(false);
					} else {
						MyService.mConnectedThread.write("k");
						cap.setPressed(false);
					}

				} else {
					Storage.setCorp(false);
					if (craci.isPressed()) {
						MyService.mConnectedThread.write("j");
					}
				}
				return true;
			}
		});
		craci = (Button) findViewById(R.id.craci);
		if (Storage.getPicioare() == true) {
			craci.setPressed(true);
		}
		craci.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();
				craci.setPressed(!craci.isPressed());
				// if(craci.isPressed())
				// {fan1.setPressed(true);
				// }
				if (craci.isPressed()) {
					Storage.setPicioare(true);
					if (corp.isPressed()) {

						MyService.mConnectedThread.write("l");
						cap.setPressed(false);
					} else {
						MyService.mConnectedThread.write("j");
						cap.setPressed(false);
					}
				} else {
					Storage.setPicioare(false);
					if (corp.isPressed()) {
						MyService.mConnectedThread.write("k");
					}
				}
				return true;
			}
		});

		/*
		 * fan4 = (Button)findViewById(R.id.fan4);
		 * 
		 * fan4.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // show
		 * interest in events resulting from ACTION_DOWN
		 * if(event.getAction()==MotionEvent.ACTION_DOWN) return true; // don't
		 * handle event unless its ACTION_UP so "doSomething()" only runs once.
		 * if(event.getAction()!=MotionEvent.ACTION_UP) return false; //
		 * doSomething(); fan4.setPressed( !fan4.isPressed() );
		 * if(fan4.isPressed()){fan3.setPressed(true);}
		 * if(fan3.isPressed()){fan2.setPressed(true);}
		 * if(fan2.isPressed()){fan1.setPressed(true);}
		 * MyService.mConnectedThread.write("17"); if(fan4.isPressed()==false){
		 * MyService.mConnectedThread.write("16");} return true; } });
		 * 
		 * fan3 = (Button)findViewById(R.id.fan3);
		 * 
		 * fan3.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // show
		 * interest in events resulting from ACTION_DOWN
		 * if(event.getAction()==MotionEvent.ACTION_DOWN) return true; // don't
		 * handle event unless its ACTION_UP so "doSomething()" only runs once.
		 * if(event.getAction()!=MotionEvent.ACTION_UP) return false; //
		 * doSomething(); fan3.setPressed( !fan3.isPressed() );
		 * if(fan3.isPressed()){fan2.setPressed(true);}
		 * if(fan2.isPressed()){fan1.setPressed(true);}
		 * 
		 * if(!fan3.isPressed()){fan4.setPressed(false);}
		 * MyService.mConnectedThread.write("16"); if(fan3.isPressed()==false){
		 * MyService.mConnectedThread.write("15");} return true; } });
		 * 
		 * fan2 = (Button)findViewById(R.id.fan2);
		 * 
		 * fan2.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // show
		 * interest in events resulting from ACTION_DOWN
		 * if(event.getAction()==MotionEvent.ACTION_DOWN) return true; // don't
		 * handle event unless its ACTION_UP so "doSomething()" only runs once.
		 * if(event.getAction()!=MotionEvent.ACTION_UP) return false; //
		 * doSomething(); fan2.setPressed( !fan2.isPressed() );
		 * if(fan2.isPressed()){fan1.setPressed(true);}
		 * 
		 * if(!fan2.isPressed()){fan3.setPressed(false);}
		 * if(!fan3.isPressed()){fan4.setPressed(false);}
		 * MyService.mConnectedThread.write("15"); if(fan2.isPressed()==false){
		 * MyService.mConnectedThread.write("14");} return true; } });
		 * 
		 * fan1 = (Button)findViewById(R.id.fan1);
		 * 
		 * fan1.setOnTouchListener(new OnTouchListener() {
		 * 
		 * @Override public boolean onTouch(View v, MotionEvent event) { // show
		 * interest in events resulting from ACTION_DOWN
		 * if(event.getAction()==MotionEvent.ACTION_DOWN) return true; // don't
		 * handle event unless its ACTION_UP so "doSomething()" only runs once.
		 * if(event.getAction()!=MotionEvent.ACTION_UP) return false; //
		 * doSomething(); fan1.setPressed( !fan1.isPressed() );
		 * MyService.mConnectedThread.write("14");
		 * if(!fan1.isPressed()){fan2.setPressed(false);}
		 * if(!fan2.isPressed()){fan3.setPressed(false);}
		 * if(!fan3.isPressed()){fan4.setPressed(false);}
		 * if(fan1.isPressed()==false){ MyService.mConnectedThread.write("13");}
		 * return true; } });
		 */
		templus = (Button) findViewById(R.id.tempplus);
		templus.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				if (tempsetup < 11) {
					tempsetup++;
					Storage.tempsetup = tempsetup;
				}

				if (tempsetup == 0) {
					MyService.mConnectedThread.write("q");
					ImageView image1 = (ImageView) findViewById(R.id.degwan);
					image1.setImageResource(R.drawable.low);
					ImageView image2 = (ImageView) findViewById(R.id.deg);
					image2.setVisibility(View.INVISIBLE);

				} else {
					if (tempsetup == 1) {
						MyService.mConnectedThread.write("r");
						ImageView image1 = (ImageView) findViewById(R.id.degwan);
						image1.setImageResource(R.drawable.temp17);
						ImageView image2 = (ImageView) findViewById(R.id.deg);
						image2.setVisibility(View.VISIBLE);
					}

					else {
						if (tempsetup == 2) {
							MyService.mConnectedThread.write("s");

							ImageView image1 = (ImageView) findViewById(R.id.degwan);
							image1.setImageResource(R.drawable.temp18);
						}

						else {
							if (tempsetup == 3) {
								MyService.mConnectedThread.write("t");
								ImageView image1 = (ImageView) findViewById(R.id.degwan);
								image1.setImageResource(R.drawable.temp19);
							}

							else {
								if (tempsetup == 4) {
									MyService.mConnectedThread.write("u");
									ImageView image1 = (ImageView) findViewById(R.id.degwan);
									image1.setImageResource(R.drawable.temp20);
								}

								else {
									if (tempsetup == 5) {
										MyService.mConnectedThread.write("v");
										ImageView image1 = (ImageView) findViewById(R.id.degwan);
										image1.setImageResource(R.drawable.temp21);
									}

									else {

										if (tempsetup == 6) {
											MyService.mConnectedThread
													.write("x");
											ImageView image1 = (ImageView) findViewById(R.id.degwan);
											image1.setImageResource(R.drawable.temp22);
										}

										else {

											if (tempsetup == 7) {
												MyService.mConnectedThread
														.write("y");
												ImageView image1 = (ImageView) findViewById(R.id.degwan);
												image1.setImageResource(R.drawable.temp23);
											}

											else {

												if (tempsetup == 8) {
													MyService.mConnectedThread
															.write("z");
													ImageView image1 = (ImageView) findViewById(R.id.degwan);
													image1.setImageResource(R.drawable.temp24);
												}

												else {

													if (tempsetup == 9) {
														MyService.mConnectedThread
																.write("A");
														ImageView image1 = (ImageView) findViewById(R.id.degwan);
														image1.setImageResource(R.drawable.temp25);
													}

													else {

														if (tempsetup == 10) {
															MyService.mConnectedThread
																	.write("B");
															ImageView image1 = (ImageView) findViewById(R.id.degwan);
															image1.setImageResource(R.drawable.temp26);
															ImageView image2 = (ImageView) findViewById(R.id.deg);
															image2.setVisibility(View.VISIBLE);
														}

														else {

															if (tempsetup == 11) {
																MyService.mConnectedThread
																		.write("C");
																ImageView image1 = (ImageView) findViewById(R.id.degwan);
																image1.setImageResource(R.drawable.high);
																ImageView image2 = (ImageView) findViewById(R.id.deg);
																image2.setVisibility(View.INVISIBLE);
															}

														}

													}

												}

											}

										}

									}

								}

							}
						}
					}

				}

				return true;
			}
		});
		teminus = (Button) findViewById(R.id.tempminus);
		teminus.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				if (tempsetup > 0) {
					tempsetup--;
					Storage.tempsetup = tempsetup;
				}

				if (tempsetup == 0) {
					MyService.mConnectedThread.write("q");
					ImageView image1 = (ImageView) findViewById(R.id.degwan);
					image1.setImageResource(R.drawable.low);
					ImageView image2 = (ImageView) findViewById(R.id.deg);
					image2.setVisibility(View.INVISIBLE);

				} else {
					if (tempsetup == 1) {
						MyService.mConnectedThread.write("r");
						ImageView image1 = (ImageView) findViewById(R.id.degwan);
						image1.setImageResource(R.drawable.temp17);
						ImageView image2 = (ImageView) findViewById(R.id.deg);
						image2.setVisibility(View.VISIBLE);
					}

					else {
						if (tempsetup == 2) {
							MyService.mConnectedThread.write("s");

							ImageView image1 = (ImageView) findViewById(R.id.degwan);
							image1.setImageResource(R.drawable.temp18);
						}

						else {
							if (tempsetup == 3) {
								MyService.mConnectedThread.write("t");
								ImageView image1 = (ImageView) findViewById(R.id.degwan);
								image1.setImageResource(R.drawable.temp19);
							}

							else {
								if (tempsetup == 4) {
									MyService.mConnectedThread.write("u");
									ImageView image1 = (ImageView) findViewById(R.id.degwan);
									image1.setImageResource(R.drawable.temp20);
								}

								else {
									if (tempsetup == 5) {
										MyService.mConnectedThread.write("v");
										ImageView image1 = (ImageView) findViewById(R.id.degwan);
										image1.setImageResource(R.drawable.temp21);
									}

									else {

										if (tempsetup == 6) {
											MyService.mConnectedThread
													.write("x");
											ImageView image1 = (ImageView) findViewById(R.id.degwan);
											image1.setImageResource(R.drawable.temp22);
										}

										else {

											if (tempsetup == 7) {
												MyService.mConnectedThread
														.write("y");
												ImageView image1 = (ImageView) findViewById(R.id.degwan);
												image1.setImageResource(R.drawable.temp23);
											}

											else {

												if (tempsetup == 8) {
													MyService.mConnectedThread
															.write("z");
													ImageView image1 = (ImageView) findViewById(R.id.degwan);
													image1.setImageResource(R.drawable.temp24);
												}

												else {

													if (tempsetup == 9) {
														MyService.mConnectedThread
																.write("A");
														ImageView image1 = (ImageView) findViewById(R.id.degwan);
														image1.setImageResource(R.drawable.temp25);
													}

													else {

														if (tempsetup == 10) {
															MyService.mConnectedThread
																	.write("B");
															ImageView image1 = (ImageView) findViewById(R.id.degwan);
															image1.setImageResource(R.drawable.temp26);
															ImageView image2 = (ImageView) findViewById(R.id.deg);
															image2.setVisibility(View.VISIBLE);
														}

														else {

															if (tempsetup == 11) {
																MyService.mConnectedThread
																		.write("C");
																ImageView image1 = (ImageView) findViewById(R.id.degwan);
																image1.setImageResource(R.drawable.high);
																ImageView image2 = (ImageView) findViewById(R.id.deg);
																image2.setVisibility(View.INVISIBLE);
															}

														}

													}

												}

											}

										}

									}

								}

							}
						}
					}

				}

				return true;
			}
		});

		fanplus = (Button) findViewById(R.id.fanplus);

		fanplus.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				if (fanspeed != 4) {
					fanspeed++;
				}
				if (fanspeed == 0) {
					MyService.mConnectedThread.write("d");
					ImageView image = (ImageView) findViewById(R.id.fanspeed);
					image.setImageResource(R.drawable.off);
					Storage.setFanspeed(0);

				} else {
					if (fanspeed == 1) {
						MyService.mConnectedThread.write("e");
						ImageView image = (ImageView) findViewById(R.id.fanspeed);
						image.setImageResource(R.drawable.fan1);
						Storage.setFanspeed(1);
					} else {
						if (fanspeed == 2) {
							MyService.mConnectedThread.write("f");

							ImageView image = (ImageView) findViewById(R.id.fanspeed);
							image.setImageResource(R.drawable.fan2);
							Storage.setFanspeed(2);
						} else {
							if (fanspeed == 3) {
								MyService.mConnectedThread.write("g");
								ImageView image = (ImageView) findViewById(R.id.fanspeed);
								image.setImageResource(R.drawable.fan3);
								Storage.setFanspeed(3);
							} else {
								if (fanspeed == 4) {
									MyService.mConnectedThread.write("h");
									ImageView image = (ImageView) findViewById(R.id.fanspeed);
									image.setImageResource(R.drawable.fan4);
									Storage.setFanspeed(4);
								}
							}
						}
					}

				}

				return true;
			}
		});

		fanminus = (Button) findViewById(R.id.fanminus);

		fanminus.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;

				if (fanspeed != 0) {
					fanspeed--;
				}
				if (fanspeed == 0) {
					MyService.mConnectedThread.write("d");
					ImageView image = (ImageView) findViewById(R.id.fanspeed);
					image.setImageResource(R.drawable.off);
					Storage.setFanspeed(0);

				} else {
					if (fanspeed == 1) {
						MyService.mConnectedThread.write("e");
						ImageView image = (ImageView) findViewById(R.id.fanspeed);
						image.setImageResource(R.drawable.fan1);
						Storage.setFanspeed(1);
					} else {
						if (fanspeed == 2) {
							MyService.mConnectedThread.write("f");

							ImageView image = (ImageView) findViewById(R.id.fanspeed);
							image.setImageResource(R.drawable.fan2);
							Storage.setFanspeed(2);
						} else {
							if (fanspeed == 3) {
								MyService.mConnectedThread.write("g");
								ImageView image = (ImageView) findViewById(R.id.fanspeed);
								image.setImageResource(R.drawable.fan3);
								Storage.setFanspeed(3);
							} else {
								if (fanspeed == 4) {
									MyService.mConnectedThread.write("h");
									ImageView image = (ImageView) findViewById(R.id.fanspeed);
									image.setImageResource(R.drawable.fan4);
									Storage.setFanspeed(4);
								}
							}
						}
					}

				}

				return true;
			}
		});

		scaunstg = (Button) findViewById(R.id.scaunstg);
		if (Storage.getScaunstg() == true) {
			scaunstg.setPressed(true);
		}
		scaunstg.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;

				scaunstg.setPressed(!scaunstg.isPressed());
				if (scaunstg.isPressed()) {
					Storage.setScaunstg(true);
					MyService.mConnectedThread.write("1");
				} else {
					Storage.setScaunstg(false);
					MyService.mConnectedThread.write("2");
				}
				return true;
			}
		});

		navi = (Button) findViewById(R.id.navi);
		navi.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent nav = new Intent(Ventscreen.this, Navi.class);
				startActivity(nav);
				finish();
			}
		});

		headlight = (Button) findViewById(R.id.head);
		headlight.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent head = new Intent(Ventscreen.this, Headlight.class);
				startActivity(head);
				finish();
			}
		});
		scaundr = (Button) findViewById(R.id.scaundr);
		if (Storage.getScaundr() == true) {
			scaundr.setPressed(true);
		}
		scaundr.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// show interest in events resulting from ACTION_DOWN
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					return true;
				// don't handle event unless its ACTION_UP so "doSomething()"
				// only runs once.
				if (event.getAction() != MotionEvent.ACTION_UP)
					return false;
				// doSomething();
				scaundr.setPressed(!scaundr.isPressed());
				if (scaundr.isPressed()) {
					Storage.setScaundr(true);
					MyService.mConnectedThread.write("3");
				} else {
					Storage.setScaundr(false);
					MyService.mConnectedThread.write("4");
				}
				return true;
			}
		});
		home = (Button) findViewById(R.id.home);
		home.setOnClickListener(new OnClickListener() {
			@Override
			// On click function
			public void onClick(View view) {
				// Create the intent to start another activity
				Intent home = new Intent(Ventscreen.this, MainActivity.class);
				startActivity(home);
				finish();
			}
		});

	} // onCreate ends here;

	public void onPause() {
		super.onPause();

		finish();

	}
}
